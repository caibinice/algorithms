package algorithms.leetcode;

import java.util.Arrays;

public class MaximumGap {

/**
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Example 1:

 Input: [3,6,9,1]
 Output: 3
 Explanation: The sorted form of the array is [1,3,6,9], either
 (3,6) or (6,9) has the maximum difference 3.
 Example 2:

 Input: [10]
 Output: 0
 Explanation: The array contains less than 2 elements, therefore return 0.*/


    /**
     * Suppose there are N elements in the array, the min value is min and the max value is max.
     * Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
     *
     * Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the array into n-1 buckets,
     * where k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap).
     * Since there are n-2 numbers that are not equal min or max and there are n-1 buckets,
     * at least one of the buckets are empty. We only need to store the largest number and the smallest number in each bucket.
     * After we put all the numbers into the buckets. We can scan the buckets sequentially and get the max gap.
     *
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if (min == max)
            return 0;
        int n = nums.length;
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        int bucketMin[] = new int[n];
        int bucketMax[] = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int i = (num - min) / gap;
            bucketMin[i] = Math.min(bucketMin[i], num);
            bucketMax[i] = Math.max(bucketMax[i], num);
        }

        for (int i = 0; i < bucketMin.length; ++i) {
            if (bucketMin[i] != Integer.MAX_VALUE || bucketMax[i] != Integer.MIN_VALUE) {
                gap = Math.max(gap, bucketMin[i] - min);
                min = bucketMax[i];
            }
        }
        return gap;
    }
}
