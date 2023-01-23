class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i=1 ; i<=n ; i++){
            if(count[i]==n-1) return i;
        }
        return -1;
    }
}


// The decrementing of the truster's count is to keep track of the people who trusts someone else, while incrementing the trustee's count is to keep track of the people who are trusted by someone else.

// At the end of the iteration, the Town Judge is the person whose count is equal to N-1. This is because the Town Judge is the person who is trusted by everyone but trusts no one. So, his count will be the total number of people in the town minus 1.

//When the for loop iterates through the count array and finds that the count of a person is equal to N-1, it means that this person is the Town Judge, because this person is trusted by everyone in the town but trusts no one. And as the index of the count array represents the id of the person, the return i statement returns the id of the Town Judge.

//So, when the for loop finds the Town Judge, it immediately returns the index i of that person, thus the function exits and the Town Judge's id is returned as the result of the function.
//It is worth noting that this code doesn't check if there is more than one Town Judge, so it will return the first one found.