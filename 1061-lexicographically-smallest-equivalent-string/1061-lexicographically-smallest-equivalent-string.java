// https://www.youtube.com/watch?v=1qgxjQ0Bd7M&t=25s

class Solution {
    int[] parents = new int[26];
    
    int find(int x){
        if(parents[x]==-1) return x;
        return parents[x]=find(parents[x]);
    }
    
    void Union(int x , int y){
        x = find(x);
        y = find(y);
        
        if(x!=y){
             parents[Math.max(x,y)]=Math.min(x,y);
        }
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Arrays.fill(parents,-1);
        for(int i=0 ; i<s1.length() ; ++i){
            Union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        for(int i=0 ; i<baseStr.length() ; i++){
            baseStr = baseStr.substring(0,i) + (char)(find(baseStr.charAt(i)-'a')+'a') + baseStr.substring(i+1);
        }
        return baseStr;
    }
    
}