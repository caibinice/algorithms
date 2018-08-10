package algorithms.leetcode;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int k = 0; k < n; k++) {
                nums1[k] = nums2[k];
            }
            return;
        }
        if (n == 0) return;
        int i = 0, j = 0;
        int[] num = new int[nums1.length];
        for (int k = 0; k < m + n; k++) {
            if (i >= m || (j < n && nums1[i] >= nums2[j])) {
                num[k] = nums2[j];
                j++;
            } else {
                num[k] = nums1[i];
                i++;
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = num[k];
        }
    }

    //从A[]末尾逆向排序，O(1) space
    public void mergeV2(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) {
            A[k--] = B[j--];
        }
    }



}
