class Solution{
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<int[]> heights = new ArrayList<>();
        
        for(int[] b : buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1],b[2]});
        }
        
        Collections.sort(heights, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        TreeMap<Integer,Integer> heightMap = new TreeMap<>(Collections.reverseOrder());

        heightMap.put(0,1);

        int prevHeight = 0;
        List<List<Integer>> skyLine = new LinkedList<>();

        for(int[] h : heights){
            if(h[1]<0){
                Integer cnt = heightMap.get(-h[1]);
                cnt = (cnt == null) ? 1 : cnt+1;
                heightMap.put(-h[1],cnt);
            }
            else{
                Integer cnt = heightMap.get(h[1]);
                if(cnt==1){
                    heightMap.remove(h[1]);
                }
                else{
                    heightMap.put(h[1],cnt-1);
                }
            }

            int currHeight = heightMap.firstKey();
            
            if(prevHeight!=currHeight){
                List<Integer> point = new ArrayList<>();
                point.add(h[0]);
                point.add(currHeight);
                skyLine.add(point);
                prevHeight=currHeight;
            }
        }

        return skyLine;
    }
}