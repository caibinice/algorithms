package algorithms.leetcode;

import java.util.*;

public class ThreeSum {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    //遍历
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> sl = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            sl.put(nums[i], i);//记录相同值最后的位置
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                if (sl.containsKey(target) && sl.get(target) > j) {
                    j = sl.get(nums[j]);
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            i = sl.get(nums[i]);  // To remove duplicates
        }
        return res;
    }

    //滑动窗口，双指针left right，和小left++，和大right--
    public List<List<Integer>> threeSumV2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }



}
