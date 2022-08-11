// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// Approach-> https://www.youtube.com/watch?v=5G7jNmqGUck
//            https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35220/My-Accepted-Java-Solution


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums ,int start ,int end){
        if(start>end){
            return null ;
        }
        int mid = start+(end-start)/2;
        var root = new TreeNode(nums[mid]);
        root.left = helper(nums,start,mid-1);   
        root.right = helper(nums,mid+1,end);
        return root ;
   }
}

// 1) first , find mid element , make it an root.
// 2) second, left side element will always be 1 less than from root.
// 3) Third , Right side element will always be 1 greater than from root.
// 4) difference will be of 1 from left to root or right to root .
// 5) atlast return root.
