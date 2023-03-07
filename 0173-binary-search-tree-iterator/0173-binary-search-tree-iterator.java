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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        // we take the root and then put all left node into the stack
        pushAll(root);
    }
    
    
    public int next() {
        // pickup the smallest left element which is the last element
        TreeNode tmpNode = stack.pop();
        // if right will exists then it will go to left and push all left nodes 
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    // if stack is Empty return false otherwise true
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        // First, it pushes the current value of "node" onto the "stack" array. 
        // then, it sets "node" to the value of its left child node. (pushes all node in the left)
        for(; node!=null ; stack.push(node) , node=node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */