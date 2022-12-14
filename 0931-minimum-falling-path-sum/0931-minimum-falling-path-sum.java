// https://www.youtube.com/watch?v=oJ5leqo6vjg
// https://leetcode.com/problems/minimum-falling-path-sum/discuss/776004/Easy-Java-Solution-using-DP

class Solution {
    public int minFallingPathSum(int[][] A) {
       int dp[][] = new int[A.length][A.length];
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<A.length ; i++){
            dp[0][i]=A[0][i];
        }
        for(int i=1 ; i<A.length ; i++){
            for(int j=0 ; j<A.length ; j++){
                if(j==0) dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==A.length-1) dp[i][j] = A[i][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);
                else dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]);
            }
        }
        // The minimum path sum is minimum of the last row in DP matrix
        for(int i = 0 ; i<A.length ; i++){
            if(dp[A.length-1][i]<min) min=dp[A.length-1][i];
        }
        return min ;
    }
}



//----------------------------------------------------------------------------------------


// Must Visit this Code also Once
// https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP

// public int minFallingPathSum(int[][] A) {
//   for (int i = 1; i < A.length; ++i)
//     for (int j = 0; j < A.length; ++j)
//       A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
//   return Arrays.stream(A[A.length - 1]).min().getAsInt();
// }   