class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int min_shots = 0;
        double end_check = - Double.POSITIVE_INFINITY;


        for(int[] point : points)
        {
            if(point[0] > end_check){
                min_shots += 1;
                end_check = point[1];
            }
        }
       
        return min_shots;
        
    }
}