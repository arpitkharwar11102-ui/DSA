class Solution {
    public int maxProduct(int[] nums) {
        

        int i = 0;
        int min_end = nums[0];
        int max_end = nums[0];
        int res = nums[0];

        for(i = 1 ; i<nums.length ; i++)
        {
            int v1 = nums[i];
            int v2 = min_end * nums[i];
            int v3 = max_end * nums[i];

            max_end = Math.max(v1 , Math.max(v2,v3));
            min_end = Math.min(v1 , Math.min(v2 , v3));

            res = Math.max(res , Math.max(max_end , min_end));
        }

        return res;
    }
}