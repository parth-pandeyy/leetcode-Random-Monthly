// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// Approach -> https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231140/Solved-Add-clarification-for-the-output-order
//             https://www.youtube.com/watch?v=q_a6lpbKJdw&t=947s

class Solution {
        int min = 0 , max = 0 ;
        Map<Integer , List<Integer>> map = new HashMap();
        public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> qt = new LinkedList(); 
        Queue<Integer> qi = new LinkedList();
        qt.add(root);
        qi.add(0);
        while(!qt.isEmpty()){
            int size = qt.size();
            Map<Integer , List<Integer>> temp = new HashMap();
            for(int i =0 ; i<size ; i++){
                TreeNode cur = qt.poll();
                int idx = qi.poll();
                if(!temp.containsKey(idx)){
                    temp.put(idx , new ArrayList<Integer>());
                }
                temp.get(idx).add(cur.val);
                if(idx<min) min=idx;
                if(idx>max) max=idx;
                if(cur.left!=null){
                   qt.add(cur.left);
                   qi.add(idx-1);
                }
                if(cur.right!=null){
                    qt.add(cur.right);
                    qi.add(idx+1);
                }
            }
          for(int key : temp.keySet()){
                if(!map.containsKey(key)) map.put(key , new ArrayList<Integer>());
                List<Integer> list = temp.get(key);
                Collections.sort(list);
                map.get(key).addAll(list);     
        }
    }
          for(int i =min ; i<=max ; i++){
              List<Integer> list = map.get(i);
              res.add(list);
          }
            return res ;
    }
}
_________________________________________________________________________________________________________________________________________________________

// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
// Approach -> https://www.youtube.com/watch?v=h7xALnzllec&t=478s

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer , ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(0,root));  // creating new pair and then adding root in it. Pair is used to access left and right children of nodes
        while(!q.isEmpty()){
  // here you are entering in the map
            Pair cur = q.poll();       // cur-> current 
            if(map.containsKey(cur.hd)){
                map.get(cur.hd).add(cur.node.data);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(cur.node.data);
                map.put(cur.hd,temp);
            }
  // this part is used to maintain the level order traversal
            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        // so to convert map into List , we have to do traversing inside the map
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
            ans.addAll(entry.getValue());
        }
    return ans;
}
    static class Pair{
        // Making pair of hd & node
        int hd ; // horizontal distance 
        Node node ;  // node 
    public Pair(int hd ,Node node){
        this.node = node;
        this.hd = hd ;
    }
  }
}
