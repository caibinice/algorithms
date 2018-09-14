package algorithms.leetcode;

import java.util.HashSet;

public class SingleNumberII {

    /**
     * Given a non-empty array of integers, every element appears three times except for one,
     * which appears exactly once. Find that single one.
     * <p>
     * Note:
     *
     * Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     *
     * Example 1:
     *
     * Input: [2,2,3,2]
     * Output: 3
     * Example 2:
     *
     * Input: [0,1,0,1,0,1,99]
     * Output: 99
     */

    public int singleNumber(int[] nums) {
        HashSet<Integer> existNum = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int num:nums) {
            if (existNum.add(num)) {
                result.add(num);
            } else {
                result.remove(num);
            }
        }
        return result.iterator().next();
    }

    public int singleNumberV2(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

}
