class Solution {
    public boolean detectCapitalUse(String word) {
      boolean first = false;
      boolean AllCapital = true;
      boolean AllSmall = true;
        for(int i = 0 ; i<word.length() ; i++){
            if(i==0 && word.charAt(i)>='A' && word.charAt(i)<='Z'){
                first = true;
            }
            else if(i!=0 && word.charAt(i)>='A' && word.charAt(i)<='Z'){
                AllSmall = false;
            }
            else if(word.charAt(i)>='a' && word.charAt(i)<='z'){
               AllCapital  = false;
            }
        }
        return (first && AllCapital) || (AllSmall) || (first && AllSmall);
    }
}