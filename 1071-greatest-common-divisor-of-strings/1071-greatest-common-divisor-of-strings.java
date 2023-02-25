class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        
        int gcdVal = gcd(str1.length() , str2.length());
        return str2.substring(0,gcdVal);
        
    }
    public int gcd(int a , int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}