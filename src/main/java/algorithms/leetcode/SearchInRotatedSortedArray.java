package algorithms.leetcode;

public class SearchInRotatedSortedArray {

    /**
     * Version1 无重复元素
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
//    这道题是二分查找Search Insert Position的变体，看似有点麻烦，其实理清一下还是比较简单的。
//    因为rotate的缘故，当我们切取一半的时候可能会出现误区，所以我们要做进一步的判断。
//    具体来说，假设数组是A，每次左边缘为l，右边缘为r，还有中间位置是m。在每次迭代中，分三种情况：
//            （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
//            （2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），
//    那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
//            （3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
//    根据以上方法，每次我们都可以切掉一半的数据，所以算法的时间复杂度是O(logn)，空间复杂度是O(1)。代码如下：
    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == A[m])
                return m;
            if (A[m] < A[r]) {
                if (target > A[m] && target <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                if (target >= A[l] && target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;
    }

    public int searchV2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
                    : target < nums[0] ? Long.MIN_VALUE : Long.MAX_VALUE;
            if (num > target) {
                hi = mid - 1;
            } else if (num < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Version2 有重复元素
     */

//    原来我们是依靠中间和边缘元素的大小关系，来判断哪一半是不受rotate影响，仍然有序的。
//    而现在因为重复的出现，如果我们遇到中间和边缘相等的情况，我们就丢失了哪边有序的信息，因为哪边都有可能是有序的结果。
//    假设原数组是{1,2,3,3,3,3,3}，那么旋转之后有可能是{3,3,3,3,3,1,2}，或者{3,1,2,3,3,3,3}，
//    这样的我们判断左边缘和中心的时候都是3，如果我们要寻找1或者2，我们并不知道应该跳向哪一半。
//    解决的办法只能是对边缘移动一步，直到边缘和中间不在相等或者相遇，这就导致了会有不能切去一半的可能。
//    所以最坏情况（比如全部都是一个元素，或者只有一个元素不同于其他元素，而他就在最后一个）就会出现每次移动一步，
//    总共是n步，算法的时间复杂度变成O(n)。代码如下：
    public boolean searchII(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == target)
                return true;
            if (A[m] > A[l]) {
                if (A[m] > target && A[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[m] < A[l]) {
                if (A[m] < target && A[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }


}
