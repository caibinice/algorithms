package algorithms.leetcode;

public class FactorialTrailingZeroes {

    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     * <p>
     * Example 1:
     * <p>
     * Input: 3
     * Output: 0
     * Explanation: 3! = 6, no trailing zero.
     * Example 2:
     * <p>
     * Input: 5
     * Output: 1
     * Explanation: 5! = 120, one trailing zero.
     * Note: Your solution should be in logarithmic time complexity.
     */


    /**
     *
     * This question is pretty straightforward.

     Because all trailing 0 is from factors 5 * 2.

     But sometimes one number may have several 5 factors, for example, 25 have two 5 factors,
     125 have three 5 factors. In the n! operation, factors 2 is always ample.
     So we just count how many 5 factors in all number from 1 to n.
     *
     * 一个2和5组成一个0，在n！种，2总是多于5的，所以只需要计算5及其倍数出现了多少次
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    //非递归算法
    public int trailingZeroesV2(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
