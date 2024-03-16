class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder rvrs_word = new StringBuilder();
        for(int i=words.length-1 ; i>=0 ; i--){
            if(!words[i].isEmpty()) rvrs_word.append(words[i]).append(" ");
        }
        return rvrs_word.toString().trim();
    }
}