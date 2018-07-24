package algorithms.leetcode;

public class BinaryGap {

    /**
     * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
     * If there aren't two consecutive 1's, return 0.
     * Example 1:
     * <p>
     * Input: 22
     * Output: 2
     * Explanation:
     * 22 in binary is 0b10110.
     * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
     * The first consecutive pair of 1's have distance 2.
     * The second consecutive pair of 1's have distance 1.
     * The answer is the largest of these two distances, which is 2.
     * Example 2:
     * <p>
     * Input: 5
     * Output: 2
     * Explanation:
     * 5 in binary is 0b101.
     * Example 4:
     * <p>
     * Input: 8
     * Output: 0
     * Explanation:
     * 8 in binary is 0b1000.
     * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
     * Note:
     * 1 <= N <= 10^9
     */


    public int binaryGap(int N) {
        int num = N;
        int gap = 0;
        int temp = 0;
        boolean getFirst = false;
        while (num > 0) {
            int divide = num / 2;
            int mod = num - divide * 2;
            num = divide;
            if (mod != 0) {
                if (!getFirst) {
                    getFirst = true;
                } else {
                    gap = Math.max(temp + 1, gap);
                    temp = 0;
                }
            } else if (getFirst) {
                temp++;
            }
        }
        return gap;
    }


}
