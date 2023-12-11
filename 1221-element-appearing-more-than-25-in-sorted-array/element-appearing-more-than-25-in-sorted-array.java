class Solution {
    public int findSpecialInteger(int[] arr) {
        int count=1;
        int appear=1;
        int ans=1;
        for(int i=0 ; i<arr.length-1 ; i++){
            if(arr[i]==arr[i+1]){
                count++;
                if(appear < count){
                    appear=count;
                    ans = arr[i];
                }
            }
            else count=1;
        }
        return ans;
    }
}