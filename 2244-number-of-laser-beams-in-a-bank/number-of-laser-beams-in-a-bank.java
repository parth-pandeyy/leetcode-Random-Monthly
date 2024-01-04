class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0 , prev = 0;
        for(String s : bank){
            int count = 0;
            for(int i = 0 ; i < s.length() ; i++){
                if(s.charAt(i) == '1') count++;
            }
            if(count>0){
                ans += prev*count;
                prev = count;
            }
        }
        return ans;
    }
}



//------------------------------------------


// "011001","000000","010100","001000"


// count = 0, 3, 0, 2, 1

// ans = 0, 0, 6, 8 => ans = .8

// prev = 0, 3, 2, 1, 