// https://leetcode.com/problems/climbing-stairs/discuss/25299/Basically-it's-a-fibonacci.
// https://www.youtube.com/watch?v=mLfjzJsN8us
class Solution {
    public int climbStairs(int n) {
       // if(n<=0) return 0;
       // if(n<=1) return 1;
       // if(n<=2) return 2;
       if(n==1 || n==2) return n ;
       int Nminus1=2;
       int Nminus2=1;
       int allWays=0;
       for(int i=2;i<n;i++){
           allWays = Nminus1+Nminus2;
           Nminus2=Nminus1;
           Nminus1=allWays;
       }
       return allWays;
    }
}
