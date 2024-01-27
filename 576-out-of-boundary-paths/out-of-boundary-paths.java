class Solution {
    public int findPaths(int startRow, int startColumn, int maxMove, int i, int j) {
        int[][][] dp = new int[maxMove+1][startRow+1][startColumn+1];
        for(int[][] array2D : dp){
            for(int[] array1D : array2D){
                Arrays.fill(array1D, -1);
            }
        }
        dp[maxMove][i][j] = helper(startRow,startColumn,maxMove,i,j,0,dp);
        return dp[maxMove][i][j];
    }

    int mod = (int) Math.pow(10,9)+7;

    public int helper(int row, int col, int maxMove, int x, int y, int moves, int[][][] dp){
        if(x<0 || y<0 || x>=row || y>=col) return 1;

        if(moves==maxMove) return 0;

        if(dp[moves][x][y] != -1) return dp[moves][x][y] % mod;

        int tempVal = 0;
        tempVal = (tempVal + helper(row,col,maxMove,x,y-1,moves+1,dp)) % mod;
        tempVal = (tempVal + helper(row,col,maxMove,x-1,y,moves+1,dp)) % mod;
        tempVal = (tempVal + helper(row,col,maxMove,x+1,y,moves+1,dp)) % mod;
        tempVal = (tempVal + helper(row,col,maxMove,x,y+1,moves+1,dp)) % mod;

        dp[moves][x][y] = tempVal;
        return dp[moves][x][y] % mod;
    }
}