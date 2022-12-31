class Solution {
   public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsSearch(graph,0,ans,path);
        return ans;
    }
   public void dfsSearch(int[][] graph,int node ,List<List<Integer>> ans , List<Integer> path){
         if(node==graph.length-1){
             ans.add(new ArrayList<Integer>(path));
             return;
         }
         for(int nextNode : graph[node]){
             path.add(nextNode);
             dfsSearch(graph,nextNode,ans,path);
             path.remove(path.size()-1);
         }
   } 
}