package algorithms.leetcode;

public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the peek.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the peek?
     * <p>
     * Note: Given n will be a positive integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the peek.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     * <p>
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the peek.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */

    //暴力法 O(n^2)
    public int climbStairsV0(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //动态规划，考虑走到n级台阶，可以认为是从n-1级走1步，或者n-2级走2步，所以走法是n-1步和n-2步的和 O(n)
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //斐波那契数列公式 Binets Method O(log(n))
    public int climbStairsV3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
