// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/discuss/623673/Concise-explanation-with-a-Picture-for-Visualization

// https://www.youtube.com/watch?v=duBxBNmKFWI

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,List<Integer>> graph = createGraph(edges); // store the edges
        HashMap<Integer,Boolean> visited = new HashMap<>();
        
        return dfs(graph , 0 , hasApple , 0 , visited);//cost of reaching root is 0 & all other is 2
    }
    
    private int dfs(Map<Integer,List<Integer>> graph, int node, List<Boolean> hasApple, int intialTime , HashMap<Integer,Boolean> visited){
        Boolean v = visited.getOrDefault(node,false);
        if(v) return 0;
        visited.put(node,true);
        
        int childTime=0;  //time for traversing all children. 
        for(int n : graph.getOrDefault(node , new ArrayList<>())){
            childTime += dfs(graph , n , hasApple , 2 , visited);  // check recursively for all apples in subtrees.
        }
        
        if(childTime==0 && hasApple.get(node)==false){
            // If no child has apples, then we won't traverse the subtree, so cost will be zero.
           // similarly, if current node also does not have the apple, we won't traverse this branch at all, so cost will be zero.
            return 0;
        }
        return intialTime+childTime;
    }
    
    private HashMap<Integer,List<Integer>> createGraph(int[][] edges){
        HashMap<Integer,List<Integer>> graph= new HashMap<>();
        for(int i=0 ; i<edges.length ; i++){
          
            List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);                        // Adjecency list representaton
            graph.put(edges[i][0],list);
            
            list = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);                        // Adjecency list representation
            graph.put(edges[i][1],list);
            
        }
        return graph;
        
    }
}
