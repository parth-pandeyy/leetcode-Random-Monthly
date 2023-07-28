//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0 ;
	    for(int i=0 ; i<n ; i++) sum+=arr[i];
	    
	    
	    boolean[][] t = new boolean[n+1][sum/2+1];
	    isSubsetSum(arr,n,sum/2,t);
	    
	    int ans = Integer.MAX_VALUE;
	    
	    for(int j=0 ; j<=sum/2 ; j++){
	        if(t[n][j]){
	            ans = Math.min(ans,Math.abs(sum-2*j));
	        }
	    }
	    return ans;
	} 
	
	
	public boolean isSubsetSum(int[] arr, int n, int sum, boolean[][] t){
	    
	    
	    for(int i=0 ; i<sum+1 ; i++) t[0][i]=false;
	    for(int j=0 ; j<n+1 ; j++) t[j][0]=true;
	    
	    for(int i=1 ; i<n+1 ; i++){
	        for(int j=1 ; j<sum+1 ; j++){
	            
	            if(arr[i-1]<=j){
	                t[i][j]=(t[i-1][j-arr[i-1]] || t[i-1][j]);
	            }
	            else{
	                t[i][j]=t[i-1][j];
	            }
	        }
	    }
	    return t[n][sum];
	}
}
