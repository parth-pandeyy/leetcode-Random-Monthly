class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> list = new ArrayList<>();
        String ans;
        // why 3 because 255 has length of 3
        for(int aLen=1 ; aLen<=3 ; aLen++){
            for(int bLen=1 ; bLen<=3 ; bLen++){
                for(int cLen=1 ; cLen<=3 ; cLen++){
                    int dLen = len-aLen-bLen-cLen;
                    if(dLen>0 && dLen<=3 && aLen+bLen+cLen+dLen==len){
                        
                       int A = Integer.parseInt(s.substring(0,aLen));
                       int B = Integer.parseInt(s.substring(aLen,aLen+bLen));
                       int C = Integer.parseInt(s.substring(aLen+bLen,aLen+bLen+cLen));
                       int D =Integer.parseInt(s.substring(aLen+bLen+cLen,aLen+bLen+cLen+dLen));
                        
                       if(A<=255 && B<=255 && C<=255 && D<=255){
                          ans = A+"."+B+"."+C+"."+D;
// The +3 is being added because the 'ans' string is composed of 4 integers separated by '.' which takes up 3 characters. If the length of 'ans' is equal to the length of 's' plus 3, it means that the resulting IP address is valid and therefore it is added to the 'ret' list which is a list of all valid IP addresses. 
                          if(ans.length()==len+3){
                              list.add(ans);
                          } 
                       }  
                    }
                }
            }
        }
        return list;
    }
}




