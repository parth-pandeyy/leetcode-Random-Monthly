// https://leetcode.com/problems/power-of-four/
// approach-> https://www.youtube.com/watch?v=ZvLg05hEMd0&t=68s

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
