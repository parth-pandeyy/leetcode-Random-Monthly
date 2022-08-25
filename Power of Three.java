https://leetcode.com/problems/power-of-three/

class Solution {
    public boolean isPowerOfThree(int n) {
      while(n>1){
          if(n%3!=0){
              return false;
          }
          n/=3;
      }
         if(n==1){
            return true ;
        }
        return false ;
    }
}

// Another approach ->
//     public boolean isPowerOfFour(int n) {
//       if(n>1) while(n%3==0) n /= 3;
//       return n==1;    
//     }
