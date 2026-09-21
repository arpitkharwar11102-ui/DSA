class Solution {
    public boolean isPalindrome(String s) {

       int left = 0 , right = s.length()-1;

      while(left < right)
      {
        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }

        char currLeft = s.charAt(left);
        char currRight = s.charAt(right);

        if(Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)){
            return false;
        }
        left++;
        right--;
      }

      return true;
}
}