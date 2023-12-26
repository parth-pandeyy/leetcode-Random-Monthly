// class Solution {
//     public int numDecodings(String s) {
//         return s.length()==0 ? 0 :  numDecodings(0,s);
//     }

//     private int numDecodings(int p, String s){
//         int n = s.length();
//         if(p==n) return 1;
//         if(s.charAt(p)=='0') return 0;
//         int res = numDecodings(p+1,s);
//         if(p<n-1 && (s.charAt(p)=='1' || s.charAt(p)=='2' && s.charAt(p+1)<'7'))
//             res += numDecodings(p+2,s);
//         return res;
//     }
// }

//---------------------------------------------------------------------------------------

class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i = n-1 ; i>=0 ; i--) {
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }
            else{
                dp[i] = dp[i+1];
                if(i+1 < s.length() && (s.charAt(i)=='1' || s.charAt(i) == '2' && s.charAt(i+1)<'7')) 
                dp[i]+=dp[i+2];
            }
        }
         return dp[0];
    }  
}
