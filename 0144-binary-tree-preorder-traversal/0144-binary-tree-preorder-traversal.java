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
    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> preOrder = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<TreeNode>(); 
       TreeNode node = root; 
       if(node==null) return preOrder; 
       stack.push(node); 
       while(!stack.isEmpty()){
          node = stack.pop(); 
          preOrder.add(node.val);
          if(node.right!=null){
              stack.push(node.right);
          }
          if(node.left!=null){
              stack.push(node.left);
          } 
       }
       return preOrder; 
    }
}