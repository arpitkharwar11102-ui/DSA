class Solution {

    public int find(int n) {
        int sum = 0;

        while (n != 0) {
            int ld = n % 10;
            sum += ld * ld;
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = find(n);

        while (fast != 1 && slow != fast) {
            slow = find(slow);
            fast = find(find(fast));
        }

        return fast == 1;
    }
}