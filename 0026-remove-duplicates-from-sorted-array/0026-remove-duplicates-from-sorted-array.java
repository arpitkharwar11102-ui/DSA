class Solution {
    public int removeDuplicates(int[] nums) {

    int low = 0 , high = 1 , res = 1;

    while(high < nums.length)
    {
        if(nums[high] == nums[high-1])
        {
            high++;
            continue;
        }
        nums[low+1] = nums[high];
        low++;
        high++;
        res++;
    }
    return res;
    }
}