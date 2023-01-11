class Solution {
    public int maxPoints(int[][] points) {
        int ans=1;
        for(int i=0 ; i<points.length ; i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0 ; j<points.length ; j++){
                if(i==j) continue;
                double m = Math.atan2(points[i][0]-points[j][0] , points[i][1]-points[j][1]);
                if(!map.containsKey(m)){
                    map.put(m,1);
                }
                map.put(m,map.get(m)+1);
                ans = Math.max(ans,map.get(m));
            }
        }
        return ans;
    }
}


//Sure, to explain further let's say points[i] is [a,b] and points[j] is [c,d]. Then points[i][0] is a and points[i][1] is b. These are x and y coordinate of point i. Similarly, points[j][0] is c and points[j][1] is d.

//points[i][0] - points[j][0] is a-c which gives the difference between x coordinates of point i and point j. And points[i][1] - points[j][1] is b-d which gives the difference between y coordinates of point i and point j.

//When passed to Math.atan2(points[i][0] - points[j][0], points[i][1] - points[j][1]) it returns the angle formed between the line drawn between point i and point j and x-axis, also it considers the correct quadrant of the angle based on the signs of x and y.

//So this line is effectively finding the slope of the line between two points and then converting it to the angle in radians using atan2 method. This angle is unique for each line and can be used as the key in the map, to keep track of the number of points with the same slope(angle) with respect to point i.