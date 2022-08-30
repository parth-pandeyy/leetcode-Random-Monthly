// https://leetcode.com/problems/sort-the-matrix-diagonally/
// Approach -> https://www.youtube.com/watch?v=qDPHQOQsX3s
//             https://leetcode.com/problems/sort-the-matrix-diagonally/discuss/489749/JavaPython-Straight-Forward


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer , PriorityQueue<Integer>> d = new HashMap<>();  // priorityQueue is liyae use kar rahae kyuki woh value greater ko uppar store karta hai
        for(int i=0; i<m ; ++i){
            for(int j=0 ; j<n ; ++j){
                d.putIfAbsent(i-j , new PriorityQueue<>());  // .putifAbsent method value ko adjust karkae ascending order mae add kartae huae arrange kar daeta hai
                d.get(i-j).add(mat[i][j]);
            }
        }
        for(int i = 0 ; i<m ; ++i){
            for(int j = 0 ; j<n ; ++j){
              mat[i][j] = d.get(i-j).remove();         // pop kartae jaengae uppar sae kyuki uppar wala element smaller tha, aesae karkae humko greater element milaega
            }
        }
        return mat;
    }
}

Another approach ->
  
class Solution {
public int[][] diagonalSort(int[][] mat) {
    Map<Integer, Queue<Integer>> d = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
            d.computeIfAbsent(i - j, k -> new PriorityQueue<>()).add(mat[i][j]);  // .computeIfAbsent mae agar mapping wali jo key hai agar woh already present hai toh usae usko add nhi karengae or jo key nhi present hai usko add kar daengae.
        }
    }
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
            mat[i][j] = d.get(i - j).remove();
        }
    }
    return mat;
  }
}
