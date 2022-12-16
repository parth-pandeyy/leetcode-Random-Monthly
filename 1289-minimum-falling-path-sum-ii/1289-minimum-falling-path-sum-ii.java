// https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/452207/C%2B%2B-O(nm)-or-O(1)

class Solution {
    public int minFallingPathSum(int[][] A) {
        int sm=0 , fm=0 , pos=-1;
        for(int i=0 ; i<A.length ; i++){
            int fm2 = Integer.MAX_VALUE , sm2 = Integer.MAX_VALUE , pos2=-1;
            for(int j=0 ; j<A[i].length ; j++){
                int mn = (j!=pos) ? fm : sm ;
                if(A[i][j]+mn<fm2){
                    sm2=fm2;
                    fm2=A[i][j]+mn;
                    pos2=j;
                }else{
                    sm2=Math.min(sm2,A[i][j]+mn);
                }
            }
            fm=fm2;
            sm=sm2;
            pos=pos2;
        }
        return fm;
    }
}