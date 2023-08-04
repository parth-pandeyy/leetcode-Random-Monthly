class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length , res = 0 , sum = 0;
        for(int num : nums){
            sum+=num;
        }

        int N =n/2;
        List<List<Integer>> left = new ArrayList<>(N+1);
        List<List<Integer>> right = new ArrayList<>(N+1);

        for(int i=0 ; i<=N ; i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        //Storing all possible sum of left & right part
        for(int mask=0 ; mask<(1<<N) ; ++mask){
            int sz = 0 , l = 0 , r = 0;
            for(int i=0 ; i<N ; ++i){
                if((mask & (1<<i)) != 0){
                    sz++;
                    l+=nums[i];
                    r+=nums[i+N];
                }
            }
            left.get(sz).add(l);
            right.get(sz).add(r);
        }

        for(int sz=0 ; sz<=N ; ++sz){
            Collections.sort(right.get(sz));
        }

        res=Math.min(Math.abs(sum-2*left.get(N).get(0)) , Math.abs(sum-2*right.get(N).get(0)));

        //Iterating over the left part
        for(int sz=1 ; sz<N ; ++sz){
            for(int a : left.get(sz)){
                int b = (sum-2*a)/2 , rsz = N - sz;
                List<Integer> v = right.get(rsz);
                int idx = Collections.binarySearch(v,b); // Binary Search over the right part

                if(idx>=0){
                    res=Math.min(res,Math.abs(sum-2*(a+v.get(idx))));
                }
                else{
                    int insertionpoint = -idx -1;
                    if(insertionpoint<v.size()){
                        res=Math.min(res,Math.abs(sum-2*(a+v.get(insertionpoint))));
                    }
                    if(insertionpoint<0){
                        res=Math.min(res,Math.abs(sum-2*(a+v.get(insertionpoint-1))));
                    }
                }
            }
        }
        return res;
    }
}
