package algorithms.leetcode;

public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
     * adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * <p>
     * Example 2:
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }


    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
     * That means the first house is the neighbor of the last one.
     * Meanwhile, adjacent houses have security system connected
     * and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * Input: [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
     * because they are adjacent houses.
     * <p>
     * Example 2:
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     */

    public int robII(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robInArray(nums, 0, nums.length - 2), robInArray(nums, 1, nums.length - 1));
    }

    private int robInArray(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}
