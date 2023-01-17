class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;
        int countOnes = 0;
        int n = s.length();
        for(int i=0 ; i<n ; i++){
            char c = s.charAt(i);
            // if c is 1, then it will not inpact the minFlips
           // if c is 0, then 2 options we can do to make it mono incr
               // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
               // 2. flip it to 1, will not need to do anything
            if(c =='1'){
                countOnes++;
            }
            else{
                int temp1=countOnes;
                int temp2=res+1;
                res = Math.min(temp1,temp2);
            }
        }
        return res;
    }
}
