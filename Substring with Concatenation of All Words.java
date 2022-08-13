// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Approach->  https://www.youtube.com/watch?v=mIY9saZy4o0
//             https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap();
        for(String word : words){   
           map.put(word,map.getOrDefault(word,0)+1);  // if word is present then get the value and increment by 1
        }                                            // if word is not present then take 0 and increment by 1 
        List<Integer> result = new ArrayList();   
        int wordCount = words.length;                // it will be a count , which is 2 
        int wordLength = words[0].length();          // it will be length of word , which is 3
        for(int i =0 ; i<=s.length()-(wordCount*wordLength) ; i++){    // it will not interate whole string
            Map<String,Integer> seen = new HashMap();                  // used because no repeated word will come again
            int j = 0 ;
            while(j<wordCount){  // it will check the size of word
                 String Word = s.substring(i+j*wordLength , i+(j+1)*wordLength); // i+j*wordLength->it is used to point the next word index.
                                                                                 // i+(j+1)*wordLength -> it used to make next word by taking the substring of next word index.
                if(!map.containsKey(Word)){
                    break;                                                       // if word not present in map then break
                }
                seen.put(Word,seen.getOrDefault(Word,0)+1);        // if get the word then put in map and increment  by 1 otherwise if not then take 0 and increment by 1
                if(seen.get(Word)>map.getOrDefault(Word,0)){       // if word will repeat more then 1 , then break
                    break;
                }
                j++;
            }
            if(j==wordCount){
                result.add(i);
            }
        }
        return result;
    }
}
