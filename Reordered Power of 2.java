// https://leetcode.com/problems/reordered-power-of-2/submissions/

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] arr = count(n);
        for(int i = 0 ; i<31 ; ++i){   // as per mentioned that we can go till only 10^9
            if(Arrays.equals(arr,count(1<<i)))         // right shift operator , power get double on each shift
                return true ;                          // means we get the required matched number from table
        }
        return false;
    }
    // same code as Power of Four
    public int[] count(int n){
        int[] ans = new int[10];
        while(n>0){
            ans[n%10]++ ;
            n/=10;
        }
        return ans;
    }
}
