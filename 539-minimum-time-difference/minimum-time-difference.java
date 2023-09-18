class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        boolean[] seen = new boolean[24 * 60]; // To keep track of seen time points

        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            
            int totalMinutes = hour * 60 + minute; // Convert to minutes

            if (seen[totalMinutes]) {
                return 0; // If we've seen the same time point before, the difference is 0
            }

            seen[totalMinutes] = true;
        }

        int prevTime = -1;
        int firstTime = -1;
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < seen.length; i++) {
            if (seen[i]) {
                if (firstTime == -1) {
                    firstTime = i;
                }
                if (prevTime != -1) {
                    minDifference = Math.min(minDifference, i - prevTime);
                }
                prevTime = i;
            }
        }

        // Calculate the circular difference (between the first and last time points)
        int circularDifference = (24 * 60 - prevTime) + firstTime;
        minDifference = Math.min(minDifference, circularDifference);

        return minDifference;
    }
}
