class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0, curmax=0 , maxSum=nums[0] , curmin=0 , minSum=nums[0];
        for(int a : nums){
            total+=a;
            curmax=Math.max(a,curmax+a);
            maxSum=Math.max(maxSum,curmax);
            curmin=Math.min(a,curmin+a);
            minSum=Math.min(minSum,curmin);
        }
        return maxSum>0 ? Math.max(maxSum,total-minSum) : maxSum;
    }
}