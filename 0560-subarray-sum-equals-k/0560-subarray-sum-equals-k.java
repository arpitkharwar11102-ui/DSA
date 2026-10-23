class Solution {
    public int subarraySum(int[] nums, int k) {

        int sum = 0 , res = 0;

        Map<Integer , Integer> freq = new HashMap<>();
        freq.put(0,1);

        for(int i = 0 ; i<nums.length ; i++)
        {
            sum += nums[i];
            int ques = sum - k;
            res += freq.getOrDefault(ques , 0);
            freq.put(sum , freq.getOrDefault(sum,0)+1);
        }    

        return res;
    }
}