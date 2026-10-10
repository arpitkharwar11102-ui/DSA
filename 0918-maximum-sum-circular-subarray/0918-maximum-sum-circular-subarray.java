class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
       // int i = 0;
        int best1 = nums[0] , best2 = nums[0];
        int ans1 = nums[0] , ans2 = nums[0];
        int sum = nums[0];

        for(int i=1 ; i<nums.length ; i++)
        {
            sum += nums[i];

            best1 = Math.max(nums[i] , best1+nums[i]);
            ans1 = Math.max(ans1 , best1);

            best2 = Math.min(nums[i] , best2 + nums[i]);
            ans2 = Math.min(ans2 , best2);
        }
        if(ans1 < 0){
            return ans1;
        }
        int maxSum = sum - ans2;

        return Math.max(ans1 , maxSum);
    }
}