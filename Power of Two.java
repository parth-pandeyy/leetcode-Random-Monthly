// https://leetcode.com/problems/power-of-two/

class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n>1){
            if(n%2!=0){
                return false;
            }
            n/=2;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}

// Another approach ->
//     public boolean isPowerOfFour(int n) {
//       if(n>1) while(n%2==0) n /= 2;
//       return n==1;    
//     }
