// https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n =heights.length;
        Stack<Integer> st = new Stack<> ();
        int[] leftsum = new int[n];
        int[] rightsum = new int[n];
        for(int i=0 ; i<n ; i++){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();
        }
        if(st.isEmpty()) leftsum[i]=0;
        else leftsum[i]=st.peek()+1;
        st.push(i);
        }
        // clear the stack to be re-used
        while(!st.isEmpty()) st.pop();
        
        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) rightsum[i]=n-1;
            else rightsum[i]= st.peek()-1;
            st.push(i);
        }
        
        int max = 0;
        for(int i = 0 ; i<n ; i++){
          max=Math.max(max , (rightsum[i]-leftsum[i]+1)*heights[i]);
        }
        return max;
    }
}

// Optimized Approach ->
// https://www.youtube.com/watch?v=jC_cWLy7jSI&t=409s

class Solution {
    public int largestRectangleArea(int[] heights){
        Stack<Integer> st = new Stack<> ();
        int maxA = 0;
        int n = heights.length;
        for(int i = 0 ; i<=n ; i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height =  heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width=i;
                else width = i-st.peek()-1;
                maxA = Math.max(maxA , height*width);
            }
            st.push(i);
        }
        return maxA;
   }
}


