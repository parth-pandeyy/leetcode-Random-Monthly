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