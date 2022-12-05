// class Solution {
//     public int minimumAverageDifference(int[] nums){
//        long min=Integer.MAX_VALUE;
//        int sum=0 , rightsum=0 , rs=0;
//        int ans=0 , res=0 ;
//        if(nums.length==0) return 0;
//        for(int num : nums) rightsum+=num;
//        for(int i=0 ; i<nums.length ; i++) 
//        {
//           sum+=nums[i];
//           rs=rightsum-sum;
//           long diff = Math.abs(sum/(i+1)-(nums.length-i==1?0:rs/(nums.length-i-1)));
//           if(diff<min)  //  difference -> diff
//           {   
//               min=diff;
//               res = i;
//           }
//        }
//         return res;
//     }
// }


class Solution {
public int minimumAverageDifference(int[] nums) {
	int len = nums.length, res = 0;
	long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
	for (int num : nums)
		sum += num;
	for (int i = 0; i < len; i++) {
		leftSum += nums[i];
		rightSum = sum - leftSum;
		long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len-i - 1)));
		if (diff < min) {
			min = diff;
			res = i;
		}
	}
	return res;
}
}