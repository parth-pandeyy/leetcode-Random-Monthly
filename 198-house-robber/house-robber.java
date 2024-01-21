class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        else if(nums.length==1) return nums[0];

        int maxE = 0;
        int maxO = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(i%2==0){
                maxE=Math.max((maxE+nums[i]),maxO);
            }
            else maxO=Math.max((maxO+nums[i]),maxE);
        }
        return Math.max(maxE,maxO);
    }
}
