// https://www.youtube.com/watch?v=LCtzDl1uT_U
// https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length < 1) return 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
    for (int i = 2; i<nums.length; i++) {
        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
    }
    return dp[nums.length-1];
  }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int rob(int[] nums) {
   int a = 0;
    int b = 0;
    
    for (int i=0; i<nums.length; i++)
    {
        if (i%2==0)
        {
            a = Math.max(a+nums[i], b);
        }
        else
        {
            b = Math.max(a, b+nums[i]);
        }
    }
    
    return Math.max(a, b);
    }
}
