// https://leetcode.com/problems/binary-tree-pruning/
// Approach-> https://www.youtube.com/watch?v=iA0MJI1GhHQ


class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null ;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root ;
    }
}
