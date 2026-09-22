class Solution {

    private int k;
    private int n;

    private int[] arr;
    private int[] total;
    private int[][][] cnt;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;
        this.n = nums.length;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] % k;
        }

        total = new int[4 * n];
        cnt = new int[4 * n][][];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int idx = queries[qi][0];
            int val = queries[qi][1];
            int start = queries[qi][2];
            int x = queries[qi][3];

            // Keep value in range [0, k - 1]
            arr[idx] = val % k;

            // IMPORTANT:
            // x must also be in range [0, k - 1]
            x = x % k;

            // Update segment tree
            update(1, 0, n - 1, idx);

            // Initial product
            int[] runningProduct = {1 % k};

            // Query [start, n - 1]
            result[qi] = query(
                1,
                0,
                n - 1,
                start,
                n - 1,
                runningProduct,
                x
            );
        }

        return result;
    }

    // --------------------------------------------------
    // BUILD
    // --------------------------------------------------

    private void build(int node, int left, int right) {

        cnt[node] = new int[k][k];

        // Leaf
        if (left == right) {

            int value = arr[left];

            for (int p = 0; p < k; p++) {

                int product = (p * value) % k;

                cnt[node][p][product] = 1;
            }

            total[node] = value;

            return;
        }

        int mid = (left + right) >>> 1;

        build(2 * node, left, mid);
        build(2 * node + 1, mid + 1, right);

        pull(node);
    }

    // --------------------------------------------------
    // MERGE
    // --------------------------------------------------

    private void pull(int node) {

        int leftNode = 2 * node;
        int rightNode = 2 * node + 1;

        int leftTotal = total[leftNode];

        total[node] =
            (leftTotal * total[rightNode]) % k;

        int[][] current = cnt[node];
        int[][] leftCnt = cnt[leftNode];
        int[][] rightCnt = cnt[rightNode];

        for (int p = 0; p < k; p++) {

            int shifted = (p * leftTotal) % k;

            for (int x = 0; x < k; x++) {

                current[p][x] =
                    leftCnt[p][x] +
                    rightCnt[shifted][x];
            }
        }
    }

    // --------------------------------------------------
    // UPDATE
    // --------------------------------------------------

    private void update(
        int node,
        int left,
        int right,
        int idx
    ) {

        // Leaf
        if (left == right) {

            int value = arr[left];

            for (int p = 0; p < k; p++) {

                for (int x = 0; x < k; x++) {
                    cnt[node][p][x] = 0;
                }

                int product = (p * value) % k;

                cnt[node][p][product] = 1;
            }

            total[node] = value;

            return;
        }

        int mid = (left + right) >>> 1;

        if (idx <= mid) {

            update(
                2 * node,
                left,
                mid,
                idx
            );

        } else {

            update(
                2 * node + 1,
                mid + 1,
                right,
                idx
            );
        }

        pull(node);
    }

    // --------------------------------------------------
    // QUERY
    // --------------------------------------------------

    private int query(
        int node,
        int left,
        int right,
        int ql,
        int qr,
        int[] runningProduct,
        int x
    ) {

        // Outside range
        if (right < ql || left > qr) {
            return 0;
        }

        // Completely inside range
        if (ql <= left && right <= qr) {

            int p = runningProduct[0];

            int answer = cnt[node][p][x];

            // Update running product
            runningProduct[0] =
                (p * total[node]) % k;

            return answer;
        }

        int mid = (left + right) >>> 1;

        // LEFT first
        int leftAnswer = query(
            2 * node,
            left,
            mid,
            ql,
            qr,
            runningProduct,
            x
        );

        // RIGHT second
        int rightAnswer = query(
            2 * node + 1,
            mid + 1,
            right,
            ql,
            qr,
            runningProduct,
            x
        );

        return leftAnswer + rightAnswer;
    }
}