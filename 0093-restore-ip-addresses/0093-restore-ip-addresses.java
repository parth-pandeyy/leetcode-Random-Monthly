// class Solution {
//     public List<String> restoreIpAddresses(String s) {
//         int len = s.length();
//         List<String> list = new ArrayList<>();
//         String ans;
//         // why 3 because 255 has length of 3
//         for(int aLen=1 ; aLen<=3 ; aLen++){
//             for(int bLen=0 ; bLen<=3 ; bLen++){
//                 for(int cLen=0 ; cLen<=3 ; cLen++){
//                     int dLen = len-aLen-bLen-cLen;
//                     if(dLen>=0 && dLen<=3 && aLen+bLen+cLen+dLen==len){
                        
//                        int A = Integer.parseInt(s.substring(0,aLen));
//                        int B = Integer.parseInt(s.substring(aLen,aLen+bLen));
//                        int C = Integer.parseInt(s.substring(aLen+bLen,aLen+bLen+cLen));
//                        int D =Integer.parseInt(s.substring(aLen+bLen+cLen,aLen+bLen+cLen+dLen));
                        
//                        if(A<=255 && B<=255 && C<=255 && D<=255){
//                           ans = A+"."+B+"."+C+"."+D;
// // The +3 is being added because the 'ans' string is composed of 4 integers separated by '.' which takes up 3 characters. If the length of 'ans' is equal to the length of 's' plus 3, it means that the resulting IP address is valid and therefore it is added to the 'ret' list which is a list of all valid IP addresses. 
//                           if(ans.length()==len+3){
//                               list.add(ans);
//                           } 
//                        }  
//                     }
//                 }
//             }
//         }
//         return list;
//     }
// }






class Solution{
public static List<String> restoreIpAddresses(String s) {
List<String> ret = new ArrayList<>();
String ans;

    for (int a = 1; a <= 3; a++) {
        for (int b = 1; b <= 3; b++) {
            for (int c = 1; c <= 3; c++) {
                for (int d = 1; d <= 3; d++) {
                    if (a + b + c + d == s.length()) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a + b));
                        int C = Integer.parseInt(s.substring(a + b, a + b + c));
                        int D = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                        if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                            ans = A + "." + B + "." + C + "." + D;
                            if (ans.length() == s.length() + 3) {
                                ret.add(ans);
                            }
                        }
                    }
                }
            }
        }
    }
    return ret;
}
}
