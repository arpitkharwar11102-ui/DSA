class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int low = 0 , high = 0 , res = Integer.MAX_VALUE;
        int sum = 0;
        for(high = 0 ; high < nums.length ; high++)
        {
             sum +=nums[high];

            while(sum >= target)
            {
                int len = high - low + 1;
                res = Math.min(res,len);
                sum = sum - nums[low];
                low++;
            }
        }
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return res;
        }
    }
}