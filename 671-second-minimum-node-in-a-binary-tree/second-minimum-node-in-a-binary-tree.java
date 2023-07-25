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
// class Solution {
//     public int findSecondMinimumValue(TreeNode root) {
//         if(root == null) return -1;
//         if(root.left==null && root.right==null) return -1;

//         int left = root.left.val;
//         int right = root.right.val;

//         // if value same as root value, need to find the next candidate
//         if(root.left.val==root.val){
//             left=findSecondMinimumValue(root.left);
//         }
//         if(root.right.val==root.val){
//             right=findSecondMinimumValue(root.right);
//         }

//         if(left!=-1 && right!=-1){
//             return Math.min(left,right);
//         }
//         else if(left!=-1) return left;
//         else return right;

//     }
// }


// ------------------------------------------OR-------------------------------------------


class Solution {
    public int findSecondMinimumValue(TreeNode root){
        if(root==null) return -1;
        return findSecondMinValue(root,root.val);
    }

    public int findSecondMinValue(TreeNode root , int min){
        if(root == null) return -1;
        if(root.val>min) return root.val;
        int left = findSecondMinValue(root.left,min);
        int right = findSecondMinValue(root.right,min);
        return (left!=-1 && right!=-1) ? Math.min(left,right) : Math.max(left,right);
    }
}