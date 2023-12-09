class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0 ; i<n ; i++){
            if(colors[i] == 0 && !validColor(graph, colors, 1, i)) return false;
        }
        return true;
    }
    public boolean validColor(int[][] graph, int[] colors, int color, int node){
        if(colors[node]!=0) return colors[node] == color;
        colors[node] = color;
        for(int adjacent : graph[node]){
            if(!validColor(graph, colors, -color, adjacent)){ // Color it with a different color;
                return false;
            } 
        }
        return true; 
    }
}