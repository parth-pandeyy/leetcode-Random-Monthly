class Solution {
    public boolean halvesAreAlike(String s) {
       String[] halves = s.split("/");
       String a = s.substring(0,s.length()/2);
       String b = s.substring(s.length()/2);
       int cntA = 0 , cntB = 0;
       for(int i=0 ; i<s.length()/2 ; i++){
           char charA = Character.toLowerCase(a.charAt(i));
           char charB = Character.toLowerCase(b.charAt(i));
           if(charA == 'a'|| charA == 'e' || charA == 'i' || charA == 'o' || charA == 'u'){
               cntA++;
           }
           if(charB == 'a'|| charB == 'e' || charB == 'i' || charB == 'o' || charB == 'u'){
               cntB++;
           }
       }
       return cntA == cntB;
    }
}
