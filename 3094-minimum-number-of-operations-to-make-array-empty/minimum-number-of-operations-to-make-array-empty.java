import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int count = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int t = entry.getValue();

            if(t==1) return -1;

            count+=t/3;
            if(t%3!=0) count++;

            // //count += Math.ceil(t/3);
            // count += Math.floor(t / 3);
            
            // if (t % 3 !== 0) count++;
        }
        return count;
    }
}


