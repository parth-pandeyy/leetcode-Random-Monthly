class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int i : arr){
            cnt.put(i, cnt.getOrDefault(i,0)+1);
        }
        return cnt.size() == new HashSet<>(cnt.values()).size();
    }
}
