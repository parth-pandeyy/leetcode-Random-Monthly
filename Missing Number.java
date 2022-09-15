// https://leetcode.com/problems/missing-number/
// Approach -> https://www.youtube.com/watch?v=JfinxytTYFQ&t=1995s

class Solution {
    public int missingNumber(int[] nums) {
       int i = 0 ; 
       while(i<nums.length){
           int correct = nums[i];   
           if(nums[i]<nums.length && nums[i]!=nums[correct]){
               swap(nums,i,correct);
           }
           else{
               i++;
           }
       }
        for(int index=0 ; index<nums.length ; index++){   
            if(nums[index]!=index){ // agar element aur uska index equal nhi hai toh smhj lo index milgya                                            missing wala
                return index ;
            }
        }
        return nums.length;
    }
        void swap(int[] nums , int first , int second){
             int temp = nums[first];
             nums[first] = nums[second] ;
             nums[second] = temp ;
    }
 }
