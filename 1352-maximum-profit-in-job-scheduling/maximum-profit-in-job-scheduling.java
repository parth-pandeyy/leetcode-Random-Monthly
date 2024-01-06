class Job{
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit){
        this.start= start;
        this.end= end;
        this.profit = profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a,b)->a.end-b.end);

        int[] T = new int[n];
        T[0]=jobs[0].profit;
        
        for(int i=1 ; i<n ; i++){
            T[i]=Math.max(jobs[i].profit,T[i-1]);
            for(int j=i-1 ; j>=0 ; j--){
                if(jobs[j].end<=jobs[i].start){
                    T[i]=Math.max(T[i],jobs[i].profit+T[j]);
                    break;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int val : T){
            if(maxVal<val){
                maxVal=val;
            }
        }
        return maxVal;
    }
}