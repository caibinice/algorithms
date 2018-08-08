package algorithms.leetcode;

import java.util.HashSet;

public class SingleNumber {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,1,2,1,2]
     * Output: 4
     */
    //使用set
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        HashSet<Integer> num = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!num.remove(nums[i])) {
                num.add(nums[i]);
            }
        }
        return num.iterator().next();
    }

    //使用异或 已知 0^a=a^0=a,a^a=0,则a^b^a=(a^a)^b=0^b=b,所以对数组元素全部异或可得唯一不同元素
    public int singleNumberV2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }

}
