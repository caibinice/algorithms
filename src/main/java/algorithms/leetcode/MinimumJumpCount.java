package algorithms.leetcode;

public class MinimumJumpCount {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * Example:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     * Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Note:
     * You can assume that you can always reach the last index.
     */

    //穷举法
    public static int jumpV2(int[] nums) {
        numbers = nums;
        return jumpToEnd(0, 0);
    }

    private static int[] numbers;

    //穷举法
    private static int jumpToEnd(int index, int count) {
        if (index >= numbers.length - 1) return count;
        int thisWay = numbers[index];
        if (thisWay == 0) return 0;
        if (index + thisWay >= numbers.length - 1) return count + 1;
        if (thisWay == 1) return jumpToEnd(index + 1, count + 1);
        int minWay = 0;
        for (int i = 1; i <= thisWay; i++) {
            int nextWay = jumpToEnd(index + i, count + 1);
            if (minWay == 0) minWay = nextWay;
            if (nextWay != 0 && nextWay < minWay) {
                minWay = nextWay;
            }
        }
        if (minWay == 0) return 0;
        return minWay;
    }

    //贪心算法
    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
