class Solution {
    public long[] resultArray(int[] nums, int k) {

          long [] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int val = num % k;

            // Start a new subarray containing only nums[i]
            newDp[val]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {
                    int newRemainder = (int)((r * (long)val) % k);

                    newDp[newRemainder] += dp[r];
                }
            }

            dp = newDp;

            // Add all subarrays ending at current index
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}