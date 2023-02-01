class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] player = new int[n][2];
        for(int i=0 ; i<n ; i++){
            player[i][0] = ages[i];
            player[i][1] = scores[i];
        }
        
        Arrays.sort(player,(a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        // Note: From here on we dont need age at all! We only access arr to access scores!
        int[] dp = new int[n];
        dp[0]=player[0][1];
        int ans = dp[0];
        for(int i=1 ; i<n ; i++){
             dp[i] =  player[i][1]; //score
            // check for all previous players if their score is less or equal to current...
            for(int j=0 ; j<i ; j++){
                if(player[j][1]<=player[i][1]){
                   dp[i] = Math.max(dp[i],player[i][1]+dp[j]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}

//int[] dp = new int[n];                                                                         The "dp" array is used to store the maximum possible total score that can be achieved by the team of players. The value of each element in the "dp" array represents the maximum score that can be achieved by including that player.                                                       So, if "n" is equal to "ages.length", then "dp" will have "n" elements, where each element corresponds to a player and represents the maximum possible score that can be achieved by including that player in the team.                                                               By dynamically updating the values of the elements in the "dp" array as the players are considered in a particular order, the code is able to determine the overall maximum score that can be achieved by the team of players.

//If the first elements (ages) of a and b are equal (a[0] == b[0]), then the comparator returns a[1]-b[1], which is the difference between the second elements (scores) of a and b. This means that the sort order is based on the scores if the ages are equal.                                                                                                                  If the first elements (ages) of a and b are not equal (a[0] != b[0]), then the comparator returns a[0]-b[0], which is the difference between the ages of a and b. This means that the sort order is based on the ages if the ages are not equal.