class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0],losses.getOrDefault(m[0],0));
            losses.put(m[1],losses.getOrDefault(m[1],0)+1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet()){
            if(losses.get(player)<=1){
                r.get(losses.get(player)).add(player);
            }
        }
        return r;
    }
}


// win -> 1, 2, 3, 5, 5, 4, 4, 4, 10, 10

// loss -> 3, 3, 6, 6, 7, 5, 8, 9, 4, 9

//