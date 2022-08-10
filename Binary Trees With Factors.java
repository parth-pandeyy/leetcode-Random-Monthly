// https://leetcode.com/problems/binary-trees-with-factors/
//Approach -> https://www.youtube.com/watch?v=BRGz8ArRiPA&t=1324s
//            https://leetcode.com/problems/binary-trees-with-factors/discuss/125794/C%2B%2BJavaPython-DP-solution


class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long res = 0L , mod =(long)1e9+7;
        Arrays.sort(arr);
        HashMap<Integer,Long> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; ++i){
           map.put(arr[i],1L);
            for(int j=0 ; j<i ; ++j){
                if(arr[i]%arr[j]==0){
                  map.put(arr[i],(map.get(arr[i])+map.get(arr[j])*map.getOrDefault(arr[i]/arr[j],0L)) % mod);
                }   
            }
           res=(res+map.get(arr[i]))%mod;
        }
        return (int) res;
    }
}

