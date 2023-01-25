// Striver-> https://www.youtube.com/watch?v=WBgsABoClE0
// Aditya verma-> https://www.youtube.com/watch?v=szKVpQtBHh8
// pepcoding-> https://www.youtube.com/watch?v=wvaYrOp94k0

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<>(),s,0); // Backtracking
        return ans;
    }
    public void backtrack(List<List<String>> ans, List<String> templist, String s, int start){
        // Base case
        if(start==s.length()){
            ans.add(new ArrayList<>(templist));
        }
        for(int i=start ; i<s.length() ; i++){
         // only do backtracking when current string is palindrome
          if(ispalindrome(s,start,i)){
         // if the substring of s is palindrome, we add it into the step, which means we choose this substring. 
              templist.add(s.substring(start,i+1));
         //we want to do the same thing to the remaining substring.So we recursively call our function.
              backtrack(ans,templist,s,i+1);
         // remove the chosen substring, in order to try other options.
              templist.remove(templist.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s ,int low , int high){
        while(low<high){
            if(s.charAt(low++)!=s.charAt(high--)) return false;
        } 
         return true;
    }
}
