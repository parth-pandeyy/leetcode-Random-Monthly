//1) Create an empty set 's' to store all the words in the given array of strings.
//2) Iterate through the array of strings and insert each word into the set 's'.
//3) Create an empty vector 'concatenateWords' to store all the concatenated words.
//4) Iterate through the array of strings again, for each word, check if it is a concatenated      word using the function 'checkConcatenate(word)'.
//5) In the 'checkConcatenate(word)' function, use a for loop to iterate through each              substring of the word, starting from index 1 to the second last index of the word.
//6) For each substring, check if the prefix and suffix of the substring exists in the set          's'.
//7) If the prefix and suffix both exist in the set 's', then return true, indicating that the      word is a concatenated word.
//8) If the function 'checkConcatenate(word)' returns true, then insert the word into the          'concatenateWords' vector.
//9) Return the 'concatenateWords' vector.


class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<>();
        List<String> ConcatenateWords = new ArrayList();
        for(String word : words){
            s.add(word);
        }
        for(String word : words){
            if(CheckConcatenate(word,s)==true){
               ConcatenateWords.add(word);
            }
        }
        return ConcatenateWords;
    }  
    public boolean CheckConcatenate(String word , Set<String> s){
      for(int i=0 ; i<word.length() ; i++){
        String prefixWord = word.substring(0,i);
        String sufixWord = word.substring(i,word.length());
        if(s.contains(prefixWord) && (s.contains(sufixWord) || CheckConcatenate(sufixWord,s))){
            return true;
        } 
       }
        return false;
   }
}