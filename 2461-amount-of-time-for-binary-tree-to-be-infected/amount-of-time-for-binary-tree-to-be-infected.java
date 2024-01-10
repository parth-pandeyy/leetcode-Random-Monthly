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
//     static class Depth{
//         int d;
//         public Depth(int d){
//             this.d=d;
//         }
//     }
    
//     static int ans=-1;

//     public int amountOfTime(TreeNode root, int start) {
//         Depth depth = new Depth(-1);
//         infected(root,start,depth);
//         return ans;
//     }

//     public static int infected(TreeNode root, int start, Depth depth){
//         if(root==null) return 0;
//         if(root.val == start){
//             Depth.d=1;
//             return 1;
//         }

//         Depth ld = new Depth(-1);
//         Depth rd = new Depth(-1);

//         int lh = infected(root.left, start, ld);
//         int rh = infected(root.right, start, rd);

//         if(ld.d != -1){
//             ans = Math.max(ans, ld.d+1+rh);
//             depth.d = ld.d+1;
//         }
//         else if(rd.d != -1){
//             ans = Math.max(ans, rd.d+1+lh);
//             depth.d = rd.d+1;
//         }
//         return Math.max(lh, rh) + 1;
//     }
// } 


class Solution {
    private int ans;

    public int amountOfTime(TreeNode root, int start) {
        infected(root,start);
        return ans;
    }

    public int infected(TreeNode root, int start){
        if(root==null) return 0;

        int lh = infected(root.left, start);
        int rh = infected(root.right, start);

        if(root.val == start){
            ans = Math.max(lh, rh);
            return -1;
        }
        else if(lh >= 0 && rh >= 0){
            return Math.max(lh,rh)+1;
        }
        else{
            ans = Math.max(ans,Math.abs(lh-rh));
            return Math.min(lh, rh) - 1;
        }
    }
} 

