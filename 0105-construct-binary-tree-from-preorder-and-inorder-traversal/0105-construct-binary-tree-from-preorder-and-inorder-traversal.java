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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<Integer,Integer>();
        
        // put the values in the hashMap in the form of(keys,values)
        for(int i=0 ; i<inorder.length ; i++){
            inMap.put(inorder[i],i);
        }
        
        TreeNode root = BuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        
        return root;
    }
    
    public TreeNode BuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;
        
        // it used to find the root in preoder
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = inMap.get(root.val); // it is used to find the root in inorder
        int numsLeft = inRoot-inStart;    // it is used to find how many numbers in the left inorder
        
        // here we are finding left from sub-tree, while doing traversal again & again
        root.left = BuildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        
        // here we are finding right from sub-tree, while doing traversal again & again
        root.right = BuildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        
        return root;
    }
}