class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0 , neighbours = 0 ;
      int m = grid.length;
      int n = grid[0].length;
      for(int i = 0 ; i<grid.length ; i++){
          for(int j = 0 ; j<grid[0].length ; j++){
              if(grid[i][j]==1){
                  islands++;
                  if(i<grid.length-1 && grid[i+1][j]==1) neighbours++;
                  if(j<grid[0].length-1 && grid[i][j+1]==1) neighbours++;
              }
          }
      }
       return  islands*4 - neighbours*2 ;
    }
}



// the description of this problem implies there may be an "pattern" in calculating the perimeter of the islands.
// and the pattern is islands * 4 - neighbours * 2, since every adjacent islands made two sides disappeared(as picture below).
// the next problem is: how to find the neighbours without missing or recounting? i was inspired by the problem: https://leetcode.com/problems/battleships-in-a-board/
// +--+     +--+                   +--+--+
// |  |  +  |  |          ->       |     |
// +--+     +--+                   +--+--+
// 4 + 4 - ? = 6  -> ? = 2
