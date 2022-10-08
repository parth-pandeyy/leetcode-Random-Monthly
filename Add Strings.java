// https://leetcode.com/problems/add-strings/description/

import java.util.*;
import java.math.*;
class Solution {
    public String addStrings(String num1, String num2) {                       // BigInteger is used for greater values
       return String.valueOf(new BigInteger(num1).add(new BigInteger(num2))) ; // converts string into integer
    }
}
