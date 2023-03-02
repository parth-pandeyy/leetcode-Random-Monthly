class Solution {
    public int maxSubArray(int[] nums) {
        int Sum=0;
        int ans=nums[0];
        for(int i=0 ; i<nums.length ; i++){
                Sum=Math.max(nums[i],Sum+nums[i]);
                ans = Math.max(ans,Sum);
        }
        return ans;
    }
}