class Solution {
    public int minSteps(String s, String t) {
        int cnt = 0;
        StringBuilder modifiedT = new StringBuilder(t);
        for(int i=0 ; i<s.length() ; i++){
            char currentChar = s.charAt(i);
            int index = modifiedT.indexOf(String.valueOf(currentChar));
            if(index!=-1){
                modifiedT.deleteCharAt(index);
                cnt++;
            }
        }
        return s.length()-cnt;
    }
}



// t -> aba -> bba -> baa


// leetcode     practice