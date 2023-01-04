// https://www.youtube.com/watch?v=YREXQYfyQHo&t=7s

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0 ;
        for(int t : tasks){
            map.put(t,map.getOrDefault(t,0)+1); 
        }
        for(int freq : map.values()){  //.values() returns all values in the hashmap
            if(freq == 1) return -1;
            else if(freq%3==0) ans+=freq/3;
            else if(freq%3!=0) ans+=freq/3+1;
        }
        return ans;
    }
}