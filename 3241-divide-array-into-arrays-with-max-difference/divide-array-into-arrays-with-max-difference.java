class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int size = nums.length;
        if(size%3 != 0) return new int[0][0];

        Arrays.sort(nums);

        //List<List<Integer>> result = new ArrayList<>();
        int[][] result = new int[size/3][3];
        int x=0;

        for(int i=0 ; i<size ; i+=3){
            if(i+2<size && nums[i+2]-nums[i]<=k){
                result[x][0]=nums[i];
                result[x][1]=nums[i+1];
                result[x][2]=nums[i+2];
                x++;
            }
            else return new int[0][0];
        }
        return result;
    } 
}



// [1,3,4,8,7,9,3,5,1], k = 2

// [1,1,3,3,4,5,7,8,9] {sort}

// [] , [] , []

// [1,3,3,2,7,3], k = 3

// [1,2,3,3,3,7] {sort}