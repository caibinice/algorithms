package algorithms.leetcode;

public class MinimumInRotatedSortedArray {

    /**
     * Version 2
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * The array may contain duplicates.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,5]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [2,2,2,0,1]
     * Output: 0
     */
    //O(n)
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) return nums[i];
        }
        return nums[0];
    }

    //binary search O(log(n))~O(n)
    public int findMinV2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
            }
        }
        return nums[l];
    }

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     */
    //二分查找法
    public int findMinV3(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

}
