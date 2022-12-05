class Solution {
    public int minimumAverageDifference(int[] nums){
       long min=Integer.MAX_VALUE;
       long sum=0 , rightsum=0 , rs=0, ans=0;
       int res=0 ;
       if(nums.length==0) return 0;
       for(int num : nums) rightsum+=num;
       for(int i=0 ; i<nums.length ; i++) 
       {
          sum+=nums[i];
          rs=rightsum-sum;
          long diff = Math.abs(sum/(i+1)-(nums.length-i==1?0:rs/(nums.length-i-1)));
          if(diff<min)  //  difference -> diff
          {   
              min=diff;
              res = i;
          }
       }
        return res;
    }
}

