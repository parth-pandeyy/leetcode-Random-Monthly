// class Solution {
//     public String removeDuplicates(String s) {
//         int n = s.length() , i=0;
//         char[] res = s.toCharArray();
//         for(int j=0 ; j<n ; ++j,++i){
//             res[i]=res[j];
//             if(i>0 && res[i-1]==res[i]){
//                 i-=2;
//             }
//         }
//         return new String(res,0,i);
//     }
// }


class Solution{
    public String removeDuplicates(String s){
        int sb = s.length();
        StringBuilder p = new StringBuilder();
        for(char c : s.toCharArray()){
            int size=p.length();
            if(size>0 && p.charAt(size-1)==c){
                p.deleteCharAt(size-1);
            }else{
                p.append(c);
            }
        }
        return p.toString();   // .toString() is used to convert it from Stringbuilder to String
    }
}