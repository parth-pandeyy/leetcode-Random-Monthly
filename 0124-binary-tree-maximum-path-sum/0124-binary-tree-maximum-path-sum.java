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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode node){
        if(node==null) return 0 ;
        int left = Math.max(maxDepth(node.left),0);
        int right = Math.max(maxDepth(node.right),0);
        max = Math.max(max,node.val+left+right);
        return Math.max(right,left)+node.val;
    }
}