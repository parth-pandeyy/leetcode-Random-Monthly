class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // At a particular cell, we will store the number of obstacles that we can still remove after walking through that cell
        int[][] visited = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                visited[i][j]=-1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        

        //row,column,path,obstacle
        q.offer(new int[]{0,0,0,k});

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            // Exit if the current position is outside of the grid
            if(x<0 || y<0 || x>=m || y>=n){
                continue;
            }

            // Destination found
            if(x==m-1 && y==n-1){
                return t[2];
            }
            
            // If we encounter an obstacle and we can remove it
            if(grid[x][y]==1){
                if(t[3]>0){
                    t[3]--;
                }
                else{
                    continue;
                }
            }

            if(visited[x][y]!=-1 && visited[x][y]>=t[3]){
                continue;
            }

            visited[x][y]=t[3];

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                q.offer(new int[]{newX,newY,t[2]+1,t[3]});
            }
        }
        return -1;
    }
}