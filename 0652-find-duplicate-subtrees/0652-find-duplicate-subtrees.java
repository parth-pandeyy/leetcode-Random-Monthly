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
//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         List<TreeNode> res = new LinkedList<>();
//         postorder(root,new HashMap<>(),res);
//         return res;
//     }
//     public String postorder(TreeNode node, Map<String,Integer> count , List<TreeNode> res){
//         if(node==null) return"";
       
//         String representation = postorder(node.left,count,res)+","+node.val+","+postorder(node.right,count,res);
       
//         count.put(representation,count.getOrDefault(representation,0)+1);
       
//         if(count.get(representation)==2) res.add(node);
//         return representation;
//     }
// }


// Time complexity: O(2n)
// Space complexity: 0(2n)








class Solution {
public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> res = new LinkedList<>();
    postorder(root, new HashMap<>(), res);
    return res;
}

public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
    if (cur == null) return "#";  
    String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
    map.put(serial, map.getOrDefault(serial, 0) + 1);
    if (map.get(serial) == 2) res.add(cur);
    return serial;
}
}