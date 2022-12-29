/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=31

class Solution {
    public void maxparents(TreeNode root, Map<TreeNode,TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null){
               parent_track.put(current.left,current); 
               queue.offer(current.left);
            }
            if(current.right!=null){
               parent_track.put(current.right,current);
               queue.offer(current.right); 
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       Map<TreeNode,TreeNode> parent_track = new HashMap<>();
       maxparents(root,parent_track,root);
       Map<TreeNode,Boolean> visited = new HashMap<>();
       Queue<TreeNode> queue = new LinkedList<>(); 
       queue.offer(target);
       visited.put(target,true);
       int distance=0; 
       while(!queue.isEmpty()){
           int size = queue.size();
           if(distance==k) break;
           distance++;
           for(int i=0; i<size ; i++){
           TreeNode curr = queue.poll();
           if(curr.left!=null && visited.get(curr.left)==null){
              queue.offer(curr.left);
              visited.put(curr.left,true); 
           }
           if(curr.right!=null && visited.get(curr.right)==null){
              queue.offer(curr.right);
              visited.put(curr.right,true); 
           }
           if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
              queue.offer(parent_track.get(curr));
              visited.put(parent_track.get(curr),true);
           }
         }
       }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            result.add(curr.val);
        }
        return result;
    }
}

// Time complexity : O(N)
// Space complexity : O(1)