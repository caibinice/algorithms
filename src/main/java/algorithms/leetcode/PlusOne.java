package algorithms.leetcode;

import java.util.Stack;

public class PlusOne {

    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * <p>
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     * <p>
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     */
    //利用栈
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        Stack<Integer> result = new Stack<>();
        digits[len - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit > 9) {
                digit -= 10;
                if (i != 0) {
                    digits[i - 1]++;
                }
                else {
                    result.push(digit);
                    result.push(1);
                    break;
                }
            }
            result.push(digit);
        }
        int resultLen = result.size();
        int[] ans = new int[resultLen];
        int i=0;
        while (!result.empty()) {
            ans[i] = result.pop();
            i++;
        }
        return ans;
    }

    //判断某一位不超过9即可返回
    public int[] plusOneV2(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
}
