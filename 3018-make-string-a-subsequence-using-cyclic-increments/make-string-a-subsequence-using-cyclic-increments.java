class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str2.length();
        int pointer = 0;
        
        for(int ele : str1.toCharArray()){
            if(pointer == m) break;
            if(ele == str2.charAt(pointer)) pointer++;
            else if(ele == str2.charAt(pointer)-1) pointer++;
            else if(ele =='z' && str2.charAt(pointer)=='a') pointer++;
        }
        return m==pointer;
    }
}

