package algorithms.leetcode;

import java.util.LinkedList;

public class RotateArray {

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     * <p>
     * Input: [-1,-100,3,99] and k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * Note:
     * <p>
     * Try to come up as many solutions as you can,
     * there are at least 3 different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     */
    //直接使用链表存储数组，对头尾进行添加删除
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) return;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < k; i++) {
            list.addFirst(list.getLast());
            list.removeLast();
        }
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
    }

    //找到k次翻转后的起始index按顺序输出
    public void rotateV2(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1 || k <= 0) return;
        int[] ans = new int[len];
        int start = len - k % len;
        for (int i = 0; i < len; i++) {
            ans[i] = nums[(start + i) % len];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = ans[i];
        }
    }

    //数组全部前后交换位置，然后对前k个元素相互交换位置，再对后面的元素交换位置
    public void rotateV3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
