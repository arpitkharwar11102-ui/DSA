class Solution {
    public int maxSubArray(int[] nums) {
         
        int i = 0;
        int best_ending = nums[0];
        int ans = nums[0];
        
        for(i=1 ; i<nums.length ; i++)
        {
            int v1 = best_ending + nums[i];
            int v2 = nums[i];

            best_ending = Math.max(v1,v2);
            ans = Math.max(ans , best_ending);
        }
        return ans;
    }
}