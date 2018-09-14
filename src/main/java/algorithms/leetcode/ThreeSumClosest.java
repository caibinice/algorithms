package algorithms.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    //滑动窗口，排序后，以i为起点，从i+1到nums.length-1位置计算和，大于target则left++，小于target则right--
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
