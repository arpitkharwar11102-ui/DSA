class Solution {
    public int maximumSum(int[] arr) {
        
        int i=0;
        int nodel = arr[0];
        int onedel = Integer.MIN_VALUE;
        int res = arr[0];

        for(i = 1 ; i<arr.length ; i++)
        {
            int prevNodel = nodel;
            int prevOnedel = onedel;

            nodel = Math.max(nodel+arr[i] , arr[i]);

            int v2;

            if(prevOnedel == Integer.MIN_VALUE){
                v2 = arr[i];
            }
            else{
                v2 = prevOnedel + arr[i];
            }
            onedel = Math.max(v2 , prevNodel);
            res = Math.max(res , Math.max(onedel , nodel));
        }
        return res;
    }
}