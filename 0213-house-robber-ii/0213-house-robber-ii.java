//https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums,0,nums.length-2) , rob(nums,1,nums.length-1));
    }
    public int rob(int[] nums, int low , int high){
        int include=0 , exclude=0;
        for(int j=low ; j<=high ; j++){
            int i= include , e = exclude;
            include=e+nums[j];
            exclude=Math.max(e,i);
        }
        return Math.max(include,exclude);
    }
}