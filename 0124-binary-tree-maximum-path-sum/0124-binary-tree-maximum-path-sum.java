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
class Solution {
  public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxDepth(root,max);
        return max[0];
    }
    
    
    public int maxDepth(TreeNode node, int[] max){
        if(node==null) return 0;
        int left=Math.max(maxDepth(node.left,max),0);
        int right=Math.max(maxDepth(node.right,max),0);
        max[0]= Math.max(max[0],left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}