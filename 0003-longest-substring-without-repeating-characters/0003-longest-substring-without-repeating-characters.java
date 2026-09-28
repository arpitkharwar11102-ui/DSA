class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int low = 0 , res = 0;
        Map<Character , Integer> freq = new HashMap<>();

        for(int high = 0 ; high < s.length() ; high++)
        {
            char ch = s.charAt(high);
            freq.put(ch , freq.getOrDefault(ch,0)+1);
            int k = high - low + 1;

            while(freq.size() < k)
            {
                char left = s.charAt(low);
                freq.put(left , freq.get(left)-1);

                if(freq.get(left) == 0){
                    freq.remove(left);
                }
                low++;
                k = high - low+1;
            }
            res = Math.max(res,high - low+1);
        }
        return res;
    }
}