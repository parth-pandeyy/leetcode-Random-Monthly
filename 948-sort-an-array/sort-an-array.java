class Solution {
    public int[] sortArray(int[] nums) {
        int i=0;
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num : nums) q.offer(num);
        while(!q.isEmpty()) ans[i++] = q.poll();
        return ans;
    }
}