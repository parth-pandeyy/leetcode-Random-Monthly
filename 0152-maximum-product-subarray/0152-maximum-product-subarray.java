// class Solution {
//     public int maxProduct(int[] nums) {
//         if(nums.length==0) return 0;
//         if(nums.length == 1) return nums[0];
//         int maxSum=nums[0],curmax=nums[0], curmin=nums[0];
//         for(int a : nums){
//         //if we multiply Smaller number with negative number, we get bigger number.
//         //Similarly if we multiply bigger number with negative number, we get Smaller number.
//             // So because of these above reasons we are swapping.
//             if(a<0){
//                 int temp = curmax;
//                 curmax=curmin;
//                 curmin=temp;
//             }
//             curmax=Math.max(a,curmax*a);
//             curmin=Math.min(a,curmin*a);
//             maxSum=Math.max(maxSum,curmax);
//         }
//         return maxSum;
//     }
// }
class Solution {
    public int maxProduct(int[] nums) {
        int curmax=nums[0], maxSum=nums[0], curmin=nums[0];
        for(int i = 1; i < nums.length; i++){
            int a = nums[i];
            if(a<0){
                int temp = curmax;
                curmax=curmin;
                curmin=temp;
            }
            curmax=Math.max(a,curmax*a);
            curmin=Math.min(a,curmin*a);
            if(curmax < 0) curmax = a;
            maxSum=Math.max(maxSum,curmax);
        }
        return maxSum;
    }
}
