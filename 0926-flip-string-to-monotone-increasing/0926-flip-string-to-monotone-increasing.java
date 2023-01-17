class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;
        int countOnes = 0;
        int n = s.length();
        for(int i=0 ; i<n ; i++){
            char c = s.charAt(i);
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