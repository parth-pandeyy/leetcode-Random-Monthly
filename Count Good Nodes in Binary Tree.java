// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// Approach -> https://www.youtube.com/watch?v=7cp5imvDzl4
//             https://leetcode.com/problems/count-good-nodes-in-binary-tree/discuss/635259/JavaC%2B%2BPython-One-line
//             https://leetcode.com/problems/count-good-nodes-in-binary-tree/discuss/635258/JavaPython-3-Simple-recursive-and-iterative-DFS-codes-w-brief-explanation-and-analysis.


// 1) -> Update the maximum value found while recurse down to the paths from root to leaves;
// 2) -> If node value >= current maximum, count it in.
// 3) -> return the total number after the completion of all recursions.

class Solution {
    public int goodNodes(TreeNode root) {
        return preorder(root,root.val);
    }
    private int preorder(TreeNode n ,int v){
       if(n==null){
          return 0 ;
         }
       int max = Math.max(n.val,v);
      return (n.val>=v?1:0) + preorder(n.left,max) + preorder(n.right,max); 
  }
}

Another approach -> 
  
class Solution {
    public int goodNodes(TreeNode root) {
      return goodNodes(root,-10000);
    }
    public int goodNodes(TreeNode n , int v ){
        if(n==null){
            return 0 ;
        }
        int count = n.val>= v ? 1:0;
        count += goodNodes(n.left, Math.max(n.val,v));
        count += goodNodes(n.right, Math.max(n.val,v));
        return count;
    }
}


