class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int i= 0;
        int bestEnd1 = nums[0];
        int bestEnd2 = nums[0];
        int res1 = nums[0];
        int res2 = nums[0];
        int ans = nums[0];

        for(i = 1 ; i<nums.length ; i++)
        {
            int v1 = nums[i];
            int v2 = bestEnd1 + nums[i];
            int v3 = bestEnd2 + nums[i];

            bestEnd1 = Math.max(v1 , v2);
            res1 = Math.max(res1 , bestEnd1);

            bestEnd2 = Math.min(v1 , v3);
            res2 = Math.min(res2 , bestEnd2);

        }
        
        ans = Math.max(Math.abs(res1) , Math.abs(res2));
        return ans;
    }
}