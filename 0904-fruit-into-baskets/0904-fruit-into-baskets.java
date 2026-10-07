class Solution {
    public int totalFruit(int[] fruits) {

    int low = 0 , res = 0;
    Map<Integer,Integer> freq = new HashMap<>();

    for(int high = 0 ; high < fruits.length ; high++)
    {
        int ch = fruits[high];
        freq.put(ch , freq.getOrDefault(ch,0)+1);

        while(freq.size() > 2)
        {
            int left = fruits[low];
            freq.put(left , freq.get(left)-1);

            if(freq.get(left) == 0){
                freq.remove(left);
            }
            low++;
        }
        res = Math.max(res , high-low+1);
    }

    return res;
    }
}