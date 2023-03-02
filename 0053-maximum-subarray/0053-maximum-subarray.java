class Solution {
    public int maxSubArray(int[] nums) {
        int Sum=0;
        int ans=nums[0];
        for(int i : nums){
                Sum=Math.max(i,Sum+i);
                ans = Math.max(ans,Sum);
        }
        return ans;
    }
}