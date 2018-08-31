package algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindSum {

    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * 你可以假设每个输入只对应一种答案，且某一个位置的元素不能被重复利用。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * Version2
     *
     *Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

     Note:

     Your returned answers (both index1 and index2) are not zero-based.
     You may assume that each input would have exactly one solution and you may not use the same element twice.
     Example:

     Input: numbers = [2,7,11,15], target = 9
     Output: [1,2]
     Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     */

    public int[] twoSumII(int[] numbers, int target) {
        int l=0,r=numbers.length-1,k;
        while(l<r && l>=0 && r<numbers.length) {
            k = numbers[l]+numbers[r];
            if (k==target) {
                break;
            } else if (k>target) {
                r--;
            } else {
                l++;
            }
        }
        int[] ans = {l+1,r+1};
        return ans;
    }

}
