// Reference link -> https://www.youtube.com/watch?v=LGtMbNbzOC0
class Solution {
    public String shortestSuperstring(String[] words) {
        // starting + state, shortestSuperString
        Map<String,String> map = new HashMap<>();

        // mark every word as unused
        int unused = 0; // integer is used as a bit array
        for(int i=0; i<words.length ; i++){
            unused |= 1 << i;
        }

        return shortestSuperstring(words, "", unused, map);
    }

    private String shortestSuperstring(String[] words, String startWord, int unused, Map<String,String> map){
        if(unused == 0){  // 0=>000
            return startWord;
        }

        // create starting key with current word and state (110)
        String key = startWord + "|" + unused;  // 110
        if(map.containsKey(key)) return map.get(key);

        String shortest = null;
        for(int i=0; i<words.length; i++){
            if(!isConsumed(unused,i)){
                // get shortest superstring starting from an unused word
                String superstring = shortestSuperstring(words, words[i], consume(unused,i), map);
                // "append" the shortest superstring to the start word "abc", "bcd" => "abcd"
                String appended = overlapShortestString(startWord, superstring);

                // keep the shortest
                if(shortest == null || appended.length() < shortest.length()){
                    shortest=appended;
                }
            }
        }
        map.put(key, shortest);
        return shortest;
    }

    private boolean isConsumed(int unused, int i){
        return ((unused >> i) & 1) == 0;
    }

    private int consume(int unused, int i){
        return unused & ~(1 << i);
    }

    //concat string a to b. For example, "bake" and "kelt" =>"bakelt" 
    private String overlapShortestString(String a, String b) {
    int maxOverlap = 0;
    for (int i = 1; i <= Math.min(a.length(), b.length()); i++) {
        String substringA = a.substring(a.length() - i);
        String substringB = b.substring(0, i);
        if (substringA.equals(substringB)) {
            maxOverlap = i;
        }
    }
    return a + b.substring(maxOverlap);
    }
}