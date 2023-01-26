// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/discuss/3095888/Day-25-oror-Graph-DFS-oror-Easiest-Beginner-Friendly-Sol-oror-O(n)-time-and-O(n)-space
// https://www.youtube.com/watch?v=S0jZu7H7nQ0

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Approach:

//1) Initialize variables n to the size of the edges array, ans to -1, and minDist to the maximum value of an int.
//2) Create two arrays dist1 and dist2 of size n and initialize all elements to 0. Also, create two arrays visited1 and visited2 of size n and initialize all elements to false.
//3) Run the depth-first search (DFS) algorithm from node1 and update the dist1 and visited1 arrays accordingly.
//4) Run the DFS algorithm from node2 and update the dist2 and visited2 arrays accordingly.
//5) Iterate through all nodes currNode in the graph.
//6) For each node, check if it has been visited by both DFS calls, and if its maximum distance from node1 and node2 (i.e. max(dist1[currNode], dist2[currNode])) is less than the current value of minDist.
//7) If the above conditions are met, update the value of minDist and ans to the current node's distance and index, respectively.
//8) Return ans as the result.
//9) This algorithm finds the closest meeting point between two given nodes in a graph by using DFS to calculate the distance from each node to all other nodes in the graph. 
//   It only considers nodes that are reachable from both given nodes, and chooses the one that has the smallest maximum distance from the two given nodes.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
