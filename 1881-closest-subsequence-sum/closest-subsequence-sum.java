// class Solution {
//     public int minAbsDifference(int[] nums, int goal) {
//         int n = nums.length;
//         if (n == 1) return Math.min(Math.abs(goal), Math.abs(goal - nums[0]));

//         // Store all possible sum of the halves
//         int[] firstHalf = findAllSums(nums, 0, n / 2, 0);
//         int[] secondHalf = findAllSums(nums, n / 2, n - 1, n / 2);
//         Arrays.sort(secondHalf);

//         int res = Integer.MAX_VALUE;
//         for (int i = 0; i < firstHalf.length; i++) {
//             int lb = Arrays.binarySearch(secondHalf, goal - firstHalf[i]);

//             if (lb >= 0) {
//                return 0;
//             } 
//             else {
//                 int insertionPoint = -(lb + 1);
//                 if (insertionPoint > 0) {
//                 res = Math.min(res, Math.abs(goal-secondHalf[insertionPoint-1]-firstHalf[i]));
//                 }
//                 if (insertionPoint < secondHalf.length) {
//                    res = Math.min(res,Math.abs(goal-secondHalf[insertionPoint]-firstHalf[i]));
//                    }
//                 }
//             }
//             return res;
//         }

//     private int[] findAllSums(int[] nums, int start, int end, int offset) {
//         int[] res = new int[1 << (end - start + 1)];
//         int n = end - start + 1;
//         for (int i = 0; i < (1 << n); ++i) {
//             int sum = 0;
//             for (int j = 0; j < n; ++j) {
//                 if ((i & (1 << j)) != 0) {
//                     sum += nums[j + offset];
//                 }
//             }
//             res[i] = sum;
//         }
//         return res;
//     }
// }




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        if (n == 1) {
            return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        }

        int[] firstHalf = findAllSums(nums, 0, n / 2 - 1, 0);
        int[] secondHalf = findAllSums(nums, n / 2, n - 1, n / 2);
        Arrays.sort(secondHalf);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < firstHalf.length; ++i) {
            int lb = Arrays.binarySearch(secondHalf, goal - firstHalf[i]);

            if (lb >= 0) {
                return 0; // Exact match found, minimum difference is 0.
            } else {
                lb = -(lb + 1); // Convert to insertion point
                if (lb > 0) {
                    res = Math.min(res, Math.abs(goal - secondHalf[lb - 1] - firstHalf[i]));
                }
                if (lb < secondHalf.length) {
                    res = Math.min(res, Math.abs(goal - secondHalf[lb] - firstHalf[i]));
                }
            }
        }
        return res;
    }

    private int[] findAllSums(int[] nums, int start, int end, int offset) {
        int n = end - start + 1;
        int[] res = new int[1 << n];
        for (int i = 0; i < (1 << n); ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j + offset];
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
