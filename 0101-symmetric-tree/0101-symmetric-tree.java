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
    public boolean isSymmetric(TreeNode root) {
       return root==null || isSymmetrichelp(root.left,root.right);
    }
    public boolean isSymmetrichelp(TreeNode left,TreeNode right){
       if(left==null || right==null) return left==right;
       if(left.val!=right.val) return false;
       return isSymmetrichelp(left.left,right.right) && isSymmetrichelp(left.right,right.left);
    }
}