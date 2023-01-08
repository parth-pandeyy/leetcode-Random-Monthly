class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; 
        int surplus = 0;  // it will give distance btw gas & cos
        int tank=0;       
        int start=0;      // index of gas station
        for(int i=0; i<n; i++){
            surplus+=gas[i]-cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){     // if tanks goes -ve
                tank=0;     // reset tank
                start=i+1;  // update the starting index
            }
        }
        return (surplus<0) ? -1 : start;
    }
}