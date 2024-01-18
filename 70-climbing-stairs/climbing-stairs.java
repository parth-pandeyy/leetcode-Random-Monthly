class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int n1 = 2;
        int n2 = 1;
        int allWays = 0;
        for(int i=2 ; i<n ; i++){
            allWays = n1 + n2;
            n2 = n1;
            n1 = allWays;
        }
        return allWays;
    }
}


// n=4

// step1
// a = 1 + 2 => 3
// n2 = n1 => n2 = 1
// n1 = 3

// step2
// a = 3 + 1 = 4
// n2 = n1 => n2 = 3
// n1 = 4