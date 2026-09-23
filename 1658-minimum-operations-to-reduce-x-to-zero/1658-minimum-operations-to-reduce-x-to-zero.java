class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // If we need to remove the entire array
        if (target == 0) {
            return nums.length;
        }

        int low = 0;
        int sum = 0;
        int maxLen = -1;

        for (int high = 0; high < nums.length; high++) {

            sum += nums[high];

            while (sum > target && low <= high) {
                sum -= nums[low];
                low++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return nums.length - maxLen;
    }
}