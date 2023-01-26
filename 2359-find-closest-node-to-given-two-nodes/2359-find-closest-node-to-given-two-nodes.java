class Solution {
    // we are using DFS to solve the problem-
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int minDist = Integer.MAX_VALUE;
        int ans= -1;
       //dist1 store the distance from node1 to all its neighboring nodes, Similarly for dist2
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
       //visited array help us to identify whether we visited to particular node from node1 or          not, similarly for node2
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
       //calling dfs for both node1 & node2
        dfs(node1,edges,dist1,visited1);
        dfs(node2,edges,dist2,visited2);   
         // iterate each node to find the min max dist
        for(int currNode=0 ; currNode<n ; currNode++){
            if(visited1[currNode] && visited2[currNode] && minDist>Math.max(dist1[currNode],dist2[currNode])){
                 minDist=Math.max(dist1[currNode],dist2[currNode]);
                 ans = currNode;
             }    
        }
        return ans;
    }
    public void dfs(int node, int[] edges, int[] dist, boolean[] visited){
         visited[node]=true;
        // check the outgoing edges
        int neighbor = edges[node];
        // -1 means there is no outgoinf edge, so skip it
        if(neighbor!=-1 && !visited[neighbor]){
            dist[neighbor]=dist[node]+1;
            // dfs on neighboring node
            dfs(neighbor,edges,dist,visited);
        }
    }
}