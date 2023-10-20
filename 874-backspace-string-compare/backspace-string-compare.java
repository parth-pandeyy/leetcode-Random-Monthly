class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = processString(s);
        t = processString(t);
        return s.equals(t);

    }


    public String processString(String input){
        StringBuilder result = new StringBuilder();

        for(char c : input.toCharArray()){
            if(c == '#'){
                if(result.length()>0){
                    result.deleteCharAt(result.length()-1);
                }   
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
}