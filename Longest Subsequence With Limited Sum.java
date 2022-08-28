// https://leetcode.com/problems/longest-subsequence-with-limited-sum/submissions/
// Approach-> https://leetcode.com/problems/longest-subsequence-with-limited-sum/discuss/2493409/JavaC%2B%2BPython-Binary-Search

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
       int a =nums.length , b = queries.length , res[] =new int[b];
        for(int i =1 ; i<a; ++i){
            nums[i]+=nums[i-1];
        }
        for(int i =0 ;i<b ; ++i){
            int j = Arrays.binarySearch(nums,queries[i]);
            res[i]=Math.abs(j+1);
        }
         return res;
    }
}
