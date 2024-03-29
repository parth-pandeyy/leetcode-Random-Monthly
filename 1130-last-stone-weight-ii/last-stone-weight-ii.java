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
        for(int j=0 ; j<=sum/2 ; j++){
	        if(t[n][j]){
	            ans = Math.min(ans,Math.abs(sum-2*j));
	        }
	    }
	    return ans;
    }
}