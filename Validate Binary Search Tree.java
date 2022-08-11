// https://leetcode.com/problems/validate-binary-search-tree/
Approach-> https://leetcode.com/problems/validate-binary-search-tree/discuss/32109/My-simple-Java-solution-in-3-lines

class Solution {
    public boolean isValidBST(TreeNode root) {
       return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root ,long minVal,long maxVal){
        if(root==null)return true;
        if(root.val<=minVal || root.val>=maxVal)return false;
        return helper(root.left,minVal,root.val) && helper(root.right,root.val,maxVal);
    }
}
