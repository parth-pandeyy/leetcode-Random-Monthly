class Solution {
    // Recursive function to find all icreasing subsequences
    public void solve(int[] nums, int index,List<Integer> output,Set<List<Integer>> ans){
        // BaseCase : if we reached at end of the input array
        if(index>=nums.length){
           if(output.size()>1) ans.add(output);
           return; 
        }
        // if output is empty or current element is greater than or equal to last element in output
        if(output.size()==0 || nums[index]>=output.get(output.size()-1)){
            List<Integer> newOutput = new ArrayList<>(output);
            newOutput.add(nums[index]);
            solve(nums,index+1,newOutput,ans);
        }
        solve(nums,index+1,output,ans);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Intialize output and set to store all increasing subsequences
        List<Integer> output = new ArrayList<>();
        Set<List<Integer>> ans  = new HashSet<>();
        // call recursive function to find all increasing subsequences
        solve(nums,0,output,ans);
        // return ans as a List
        return new ArrayList<>(ans);
    }
}



// We are creating a copy of the output list using List<Integer> newOutput = new ArrayList<>(output); to ensure that the original output list remains unchanged when the new element is added to it.

// The output list is used as a parameter to the recursive solve() function, which adds an element to it. If we simply passed the output list to the function, the original output list would also be modified. By creating a new copy of the list, we ensure that the original output list remains unchanged and the new element is only added to the copy of the list newOutput.

// This is important because the output list is used again in the next recursion and we want to keep its original state. By creating a new copy of the list, we are able to maintain the original output list and continue the recursion with the new element added to the copy of the list.

// This process is also known as deep copy and it allows to keep the original value as it is and work on the new copy and make any changes without affecting the original value.


//                                         or

// Sure, In simple terms, when the recursive function is called, we want to add new element to the list and keep track of the list with new element and also keep the original state of the list for next recursion.

// The original list is output and the copy of the original list with new element is newOutput. We pass newOutput to the recursive function instead of output, so that the original list output remains unchanged and can be used in the next recursion.

// By using this technique, the program is able to keep track of the list with new element and also maintain the original state of the list for next recursion.