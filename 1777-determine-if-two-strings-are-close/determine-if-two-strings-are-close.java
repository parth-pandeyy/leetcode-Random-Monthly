class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        Map<Character,Integer> freqMap1 = new HashMap<>();
        Map<Character,Integer> freqMap2 = new HashMap<>();

        for(char c : word1.toCharArray()){
            freqMap1.put(c,freqMap1.getOrDefault(c,0)+1);
        }

        for(char c : word2.toCharArray()){
            freqMap2.put(c,freqMap2.getOrDefault(c,0)+1);
        }
        
        // Check if the sets of characters are the same
        if(!freqMap1.keySet().equals(freqMap2.keySet())) return false;

        // Check if the frequencies of characters are the same
        // Note: We are checking the frequencies, not the specific values
        return freqMap1.values().stream().sorted().collect(Collectors.toList()).equals(freqMap2.values().stream().sorted().collect(Collectors.toList()));
    }
}