class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int cnt=0, diff=0, ind=0;
        int prevDiff= nums[1] - nums[0];
        for(int i=1; i<nums.length-1 ; ++i){
            diff = nums[i+1]-nums[i];
            if(prevDiff==diff) ++ind;
            else{
                prevDiff=diff;
                ind=0;
            }
            cnt+=ind;
        }
        return cnt;
    }
}


//  1, 2, 3, 4, 5

//  [1,2,3] 
//  [2,3,4]
//  [3,4,5]
//  [1,2,3,4]
//  [2,3,4,5]
//  [1,2,3,4,5]