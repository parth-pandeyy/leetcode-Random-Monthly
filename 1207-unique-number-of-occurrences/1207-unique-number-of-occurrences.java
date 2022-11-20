class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i : arr){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        return count.size() == new HashSet<>(count.values()).size();
    }
}