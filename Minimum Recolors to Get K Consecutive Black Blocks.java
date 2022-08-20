// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0 , j = 0 , count = 0 , ans = Integer.MAX_VALUE ; 
        while(j<blocks.length()){
            if(blocks.charAt(j)=='W') count++;
            if(j-i+1>=k){
                ans=Math.min(ans,count);
                if(blocks.charAt(i)=='W') count--;
                i++;
            }
            j++;
        }
        return ans;
    }
}
