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

// this question is SAME AS: TWO SUM & Binary Search Tree Iterator Problems on leetcode

// public class BSTIterator {
//     private Stack<TreeNode> stack = new Stack<TreeNode>();
    
//     // reverse->true->before
//     // reverse->false->next
//     boolean reverse = true;
    
//     public BSTIterator(TreeNode root , boolean isReverse){
//         reverse=isReverse;
//         pushAll(root);
//     }
    
//     public boolean hashNext(){
//         return !stack.isEmpty();
//     }
    
//     public int next(){
//         TreeNode tmpNode = stack.pop();
//         if(reverse==false) pushAll(tmpNode.right);
//         else pushAll(tmpNode.left);
//         return tmpNode.val;
//     }
    
//     private void pushAll(TreeNode node){
//         while(node!=null){
//             stack.push(node);
//             if(reverse==true){
//                 node=node.right;
//             }else{
//                 node=node.left;
//             }
//         }  
//     }
// }
    
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         if(root==null) return false;
        
//         BSTIterator l = new BSTIterator(root,false);  // next
//         BSTIterator r = new BSTIterator(root,true);   // before
        
//         int i = l.next();  // next
//         int j = r.next();  // before
        
//         while(i<j){
//             if(i+j==k) return true;
//             else if(i+j<k) i=l.next();
//             else j=r.next();
//         }
//         return false;
//     }
// }




class Solution{
    public boolean findTarget(TreeNode root, int k){
        HashSet<Integer> set = new HashSet<>();
        return dfs(root,set,k);
    }
    
    public boolean dfs(TreeNode root ,HashSet<Integer> set ,int k){
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return dfs(root.right,set,k) || dfs(root.left,set,k);
    }
}


