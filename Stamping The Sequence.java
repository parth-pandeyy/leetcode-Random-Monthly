// https://leetcode.com/problems/stamping-the-sequence/
// Approach-> https://www.youtube.com/watch?v=EtalsGoNrBI&t=626s
//            https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int count = 0;
       List<Integer> res = new ArrayList<>() ;
       boolean[] visited = new boolean[t.length];
        while(count<t.length){
            boolean doneReplace = false;
            for(int i=0 ; i<=t.length-s.length ; i++){
                if(!visited[i] && canReplace(t,i,s)){
                count = replace(t,i,s.length,count);
                    doneReplace=true;
                    visited[i]=true;
                    res.add(i);
                    if(count==t.length){
                        break;
                    }
                }
            }
            if(!doneReplace){
                return new int[0];
            }   
        }
        int[] result = new int[res.size()];   // convert list into integer array
        for(int i =0 ; i<res.size() ; i++){
            result[i] = res.get(res.size()-i-1);
        }
        return result;
    }
    private boolean canReplace(char[]t , int pos , char[]s){
        for(int i=0 ; i<s.length ; i++){
           if(t[i+pos] != '?' && t[i+pos] != s[i]){
               return false ;
           } 
        }
    return true ;
   }
    private int replace(char[]t , int pos , int len , int count ){
        for(int i=0 ; i<len ; i++){
            if(t[i+pos]!='?'){
                t[i+pos]='?';
                count++;
            }
        }
        return count ;
    }
}
