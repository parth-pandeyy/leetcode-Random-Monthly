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
    public boolean checkTree(TreeNode root) {
        TreeNode left;
        TreeNode right;
     //   node.val 
        if(root==null) return true;
        int b = root.left.val+root.right.val;
        if(root.val==b){
            return true;
        }
        else return false;
    }
}