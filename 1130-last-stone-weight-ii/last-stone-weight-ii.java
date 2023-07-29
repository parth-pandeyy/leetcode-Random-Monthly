class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n =stones.length, sum=0 ;
        for(int i=0 ; i<n ; i++) sum+=stones[i]; 
        
        boolean[][] t = new boolean[n+1][sum/2+1];
        int ans=Integer.MAX_VALUE;

        for(int i=0 ; i<sum/2+1 ; i++) t[0][i]=false;
        for(int j=0 ; j<n+1 ; j++) t[j][0]=true;

        for(int i=1 ; i<n+1 ; i++){
            for(int j=1 ; j<sum/2+1 ; j++){
                if(stones[i-1]<=j){
                    t[i][j]=t[i-1][j-stones[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        for(int j=sum/2 ; j>=0 ; j--){
            if(t[n][j]){
                ans=j;
                break;
            }
        }
        return sum-2*ans;
    }
}












// class Solution {
// public int lastStoneWeightII(int[] stones) {
//     int n = stones.length;
//     int sum = 0;
//     int sum2=Integer.MAX_VALUE;

//     if()
//     for (int i = 0; i < n; i++) {
//         sum += stones[i];
//     }
    
//     boolean[][] t = new boolean[n + 1][sum / 2 + 1];
    
//     for (int i = 0; i < sum / 2 + 1; i++) {
//         t[0][i] = false;
//     }
//     for (int j = 0; j < n + 1; j++) {
//         t[j][0] = true;
//     }

//     for (int i = 1; i < n + 1; i++) {
//         for (int j = 1; j < sum / 2 + 1; j++) {
//             if (stones[i - 1] <= j) {
//                 t[i][j] = t[i - 1][j - stones[i - 1]] || t[i - 1][j];
//                 // No need to set t[i][j] to true here, it's already updated in the previous line.
//                 if (t[i][j]) {
//                     sum2 = Math.min(sum2, Math.abs(sum - 2 * j));
//                 }
//             } else {
//                 t[i][j] = t[i - 1][j];
//             }
//         }
//     }
//     return sum2;
// }
// }
