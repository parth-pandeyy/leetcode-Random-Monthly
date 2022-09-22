// https://leetcode.com/problems/reverse-words-in-a-string-iii/
// String class does not have reverse() method, we need to convert the input string to StringBuilder, which is achieved by using the append method of StringBuilder. 
// After that, print out the characters of the reversed string by scanning from the first till the last index.

// We can reverse each word of a string by the help of reverse(), split() and substring() methods.
// By using reverse() method of StringBuilder class, we can reverse given string. By the help of split(" ") method, we can get all words in an array.
// To get the first character, we can use substring() or charAt() method.

class Solution {
    public String reverseWords(String s) {
    String words[]=s.split(" ");  
    String reverseWord="";  
    for(String w:words){  
        StringBuilder sb=new StringBuilder(w);  
        sb.reverse();  
        reverseWord+=sb.toString()+" ";  
    }  
    return reverseWord.trim();  
    }
}
