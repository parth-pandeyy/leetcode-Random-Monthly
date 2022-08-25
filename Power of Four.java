// https://leetcode.com/problems/power-of-four/

class Solution {
    public boolean isPowerOfFour(int n) {
     while(n>1){
         if(n%4!=0){
           return false ; 
         }
         n/=4;
         }
         if(n==1){
             return true ;
         }
        return false;
    }
}

// Another approach ->
//     public boolean isPowerOfFour(int n) {
//       if(n>1) while(n%4==0) n /= 4;
//       return n==1;    
//     }
