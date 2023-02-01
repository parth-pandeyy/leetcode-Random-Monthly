// Approach:
// Create a pair array of size n where n is the size of scores and ages arrays.
// Store each player's score and age as a pair in the above array.
// Sort the pair array in increasing order of age.
// Initialize an array dp of size n and set dp[i] to be the score of player i for all 0 <= i < n.
// Initialize a variable ans to store the maximum overall score.
// Loop through the pair array from index i = 0 to i = n - 1.
// For each i, loop through j from 0 to i - 1.
// If the score of player j is less than or equal to the score of player i, update dp[i] to be the maximum of dp[i] and dp[j] + score[i].
// Set ans to be the maximum of ans and dp[i].
// Return ans as the result. 

                                                                   or

// Idea is to first sort the players by their age so that we don't have to always check both the scores and the age to see whether these two players can be in the same team.

// We sort first in the descending order of the ages.
// Now we know that for any player i, we can choose any player from 0 to i-1 as long as that player has higher score than this i-th player.

// dp[i] stores the maximum score that can be obtained when i-th player is included and all other players are between indices 0 and i-1.
// Once we get the answer for all indices, we can simply find the max and that will be the answer.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] player = new int[n][2];
        for(int i=0 ; i<n ; i++){
            player[i][0] = ages[i];  // store ages
            player[i][1] = scores[i]; // store scores
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//int[] dp = new int[n]; The "dp" array is used to store the maximum possible total score that can be achieved by the team of players. 
//                       The value of each element in the "dp" array represents the maximum score that can be achieved by including that player. 
//                       So, if "n" is equal to "ages.length", then "dp" will have "n" elements, where each element corresponds to a player and represents the maximum possible score that can be achieved by including that player in the team.
//                       By dynamically updating the values of the elements in the "dp" array as the players are considered in a particular order, the code is able to determine the overall maximum score that can be achieved by the team of players.

    
// Arrays.sort(player,(a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
// If the first elements (ages) of a and b are equal (a[0] == b[0]), then the comparator returns a[1]-b[1], which is the difference between the second elements (scores) of a and b. This means that the sort order is based on the scores if the ages are equal.
// If the first elements (ages) of a and b are not equal (a[0] != b[0]), then the comparator returns a[0]-b[0], which is the difference between the ages of a and b. This means that the sort order is based on the ages if the ages are not equal.
