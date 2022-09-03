// https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Approach-> https://leetcode.com/problems/average-of-levels-in-binary-tree/discuss/105107/Java-BFS-Solution
//            https://www.youtube.com/watch?v=UnTAVRofiVI

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            double sum = 0 ;
        for(int i = 0 ; i<n ; i++){
            TreeNode node = q.peek();
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            sum += node.val;
            q.poll();
            
        }
            result.add(sum/n);
      }
        return result ;
    }
}
 
