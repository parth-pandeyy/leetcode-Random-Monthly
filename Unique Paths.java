https://leetcode.com/problems/unique-paths/
Approach -> https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
            https://www.youtube.com/watch?v=x6R3OQCYmHo


class Solution {
    public int uniquePaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for(int row = 0 ; row<rows ; row++){
            dp[row][0]=1;
        }
        for(int col = 0 ; col<cols ; col++){
            dp[0][col]=1;
        }
        for(int i = 1 ; i<rows ; i++){
            for(int j = 1 ; j<cols ; j++){
                dp[i][j]= dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
