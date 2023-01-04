class Solution {
    public int minDeletionSize(String[] strs){
        int countDelete=0;
        int row = strs.length;
        int col = strs[0].length();
        for(int i=0 ; i<col ; i++){
            for(int j=0; j<row-1 ; j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    countDelete++;
                    break;
                }
            }
        }
        return countDelete;
    }
}