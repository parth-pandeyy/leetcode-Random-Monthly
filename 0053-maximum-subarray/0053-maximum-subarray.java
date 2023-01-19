class Solution {
    public int maxSubArray(int[] nums) {
        int curmax=0 , maxSum=nums[0] ;
        for(int a : nums){
            curmax=Math.max(a,curmax+a);
            maxSum=Math.max(maxSum,curmax);
        }
        return maxSum;
    }
}