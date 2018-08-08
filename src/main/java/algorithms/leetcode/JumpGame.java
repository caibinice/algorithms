package algorithms.leetcode;

public class JumpGame {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */

    //dp
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            dp[i + 1] = Math.max(dp[i] - 1, nums[i]);
            if (dp[i + 1] == 0 && i < len - 1) return false;
        }
        return true;
    }

    //greedy
    public boolean canJumpV2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    //另一种形式的贪心法，reachable表示最大可达到的index
    public boolean canJumpV3(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
