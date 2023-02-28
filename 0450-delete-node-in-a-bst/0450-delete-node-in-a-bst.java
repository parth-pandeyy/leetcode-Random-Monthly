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
    public TreeNode deleteNode(TreeNode root, int key) {
        // if null i.e., empty tree, return null
        if(root==null) return null;
        
        // keep moving left/right until you don't find key
        if(key<root.val) root.left=deleteNode(root.left,key);
        else if(key>root.val) root.right=deleteNode(root.right,key);
        
        else{
        // if key is found, check if it's left/right is empty
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        
        // otherwise find the max in right Subtree, attach the max(lastright) with the rightchild
        TreeNode maxLeft = findMax(root.left);
        root.val = maxLeft.val;
        root.left = deleteNode(root.left, maxLeft.val);
        }
        return root;
    }
    public TreeNode findMax(TreeNode root) {
    if(root.right == null) {
        return root;
    }
    return findMax(root.right);
    }
}