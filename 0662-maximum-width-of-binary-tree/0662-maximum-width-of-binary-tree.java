/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=29
// https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/1802311/C%2B%2B-oror-BFS-oror-Easy-To-Understand-oror-Full-Explanation
// https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106653/Java-One-Queue-Solution-with-HashMap
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode _node , int _num){
     node = _node;
     num = _num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q= new LinkedList<>();
       // I am using intialising list
        q.offer(new Pair(root,0)); // making an pair
        while(!q.isEmpty()){
           int size =q.size();
            // start is the index of root node for first level
            int first = q.peek().num;   // first index 
            int start=0, end=0;
         
            for(int i=0;i<size;i++){
                int curr_index = q.peek().num-first; // subtract inorder to avoid overflow
                // we will use it while inserting it children
                TreeNode node = q.peek().node;
                q.poll();
                
                if(i==0) start=curr_index;
                if(i==size-1) end=curr_index;
                
                // if left child exist
                if(node.left!=null)
                    q.offer(new Pair(node.left,curr_index*2+1));
                
                // if right child exist
                if(node.right!=null)
                    q.offer(new Pair(node.right,curr_index*2+2));
            }
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }
}




