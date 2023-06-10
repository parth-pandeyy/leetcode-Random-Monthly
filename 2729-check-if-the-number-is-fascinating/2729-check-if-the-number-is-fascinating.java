import java.util.Arrays;

class Solution {
    public boolean isFascinating(int n) {
        int a = 2 * n;
        int b = 3 * n;
        String s = Integer.toString(n) + Integer.toString(a) + Integer.toString(b);
        int[] arr = new int[10]; // Changed array size to 10
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            arr[digit]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (arr[i] != 1) { // Check for non-unique digits
                return false;
            }
        }
        return true;
    }
}
