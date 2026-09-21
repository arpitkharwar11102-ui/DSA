import java.util.HashMap;
class Solution {
public int[] twoSum(int[] numbers, int target) {

   HashMap<Integer,Integer> map = new HashMap<>();

   for(int i=0 ; i<numbers.length ; i++){
    int rem = target - numbers[i];

    if(map.containsKey(rem)){
        return new int[]{map.get(rem),i};
    }
    map.put(numbers[i],i);
   }
   return new int[]{};
}
}