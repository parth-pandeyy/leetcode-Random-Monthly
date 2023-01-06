class Solution {
    public int findMinArrowShots(int[][] points){
        if(points.length==0 || points==null){
            return 0;
        }
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow = 1;
        int end = points[0][1];
        for(int[] i : points){
            if(i[0]<=end){
                continue;
            }
            else{
                arrow++;
                end=i[1];
            }
        }
        return arrow;
    }
}