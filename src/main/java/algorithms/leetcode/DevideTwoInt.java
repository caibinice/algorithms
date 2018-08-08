package algorithms.leetcode;

public class DevideTwoInt {

    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero.
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Note:
     * <p>
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
     */

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;
        long d1 = dividend, d2 = divisor;
        long result = divideLong(Math.abs(d1), Math.abs(d2));
        result = d1 * d2 < 0 ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) result;
    }

    private long divideLong(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor, divideTimes = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            divideTimes += divideTimes;
        }
        return divideTimes + divideLong(dividend - sum, divisor);
    }

}
