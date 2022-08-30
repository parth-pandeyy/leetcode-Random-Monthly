// class Solution {
//     public void rotate(int[][] matrix) {
//         int s = 0 , e = matrix.length-1 ;
//         while(s<e){
//             int[] temp = matrix[s];
//             matrix[s]=matrix[e];
//             matrix[e]=temp;
//             s++;
//             e--;
//         }
//         for(int i =0 ; i<matrix.length ; i++){
//             for(int j =i+1 ; j<matrix[i].length ; j++){
//             int temp = matrix[i][j];
//             matrix[i][j]=matrix[j][i];
//             matrix[j][i]=temp;
//             }
//         }
//     }
// }

// Another best approach ->
    
class Solution {
    public void rotate(int[][] matrix) {
        for(int i =0 ; i<matrix.length ; i++){
            for(int j =i+1 ; j<matrix[i].length ; j++){
                int temp =0 ;
                 temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i =0 ; i<matrix.length ; i++){
            for(int j =0 ; j<matrix.length/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
     }
}
