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
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodes = new HashSet<>();
        helper(root,nodes);
        return ans;
    }
    public void helper(TreeNode curr, Set<Integer> nodes){
        if(curr == null) return;

        if(nodes.contains(curr.val)) nodes.remove(curr.val);
        else nodes.add(curr.val);

        if(curr.left==null && curr.right==null){
            if(nodes.size()<=1) ans++;
        }

        helper(curr.left, new HashSet(nodes));
        helper(curr.right, new HashSet(nodes));
    }
}