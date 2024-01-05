class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[] dp1 = new int[target+1];
        int[] dp2 = new int[target+1];
        dp1[0]=1;

        for(int i=1 ; i<=d ; i++){
            int prev = dp1[0];
            for(int j=1 ; j<=target ; j++){
                dp2[j]=prev;
                prev=(prev+dp1[j]) % mod;
                if(j>=f) prev = (prev - dp1[j - f] + mod) % mod;
            }
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
            dp2[0] = 0;
        }
        return dp1[target];
    }
}







// 1,2,3,4,5,6   target=7   n=2

// 1 + 6 = 7 => 7 - 1 = 6
// 2 + 5 = 7 => 7 - 2 = 5
// .  .  .
// .  .  .
// .  .  .
// 5 + 2 = 7 => 7 - 5 = 2
// 6 + 1 = 7 => 7 - 6 = 1


// n=3