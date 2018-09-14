package algorithms.leetcode;

public class SortColors {

    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: You are not suppose to use the library's sort function for this problem.
     * <p>
     * Example:
     * <p>
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Follow up:
     * <p>
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with a one-pass algorithm using only constant space?
     */

    //根据follow up的方法，直接遍历找出012的数量,two pass
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int num:nums)
            arr[num]++;
        for (int i = 0; i < nums.length; i++) {
            if (i<arr[0]) {
                nums[i] = 0;
            } else if (i<arr[0]+arr[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    //one pass
    public void sortColorsV2(int[] nums) {
        int index0 = 0;
        int index2 = nums.length-1;
        for (int i = 0; i <= index2 && index0 <= index2; i++) {
            while ((nums[i] == 0 && index0<=i)||( nums[i] == 2 && index2>=i)) {
                if (nums[i] == 0) {
                    nums[i] = nums[index0];
                    nums[index0] = 0;
                    index0++;
                } else {
                    nums[i] = nums[index2];
                    nums[index2] = 2;
                    index2--;
                }

            }
        }
    }

    //更简洁的one pass版本
    public void sortColorsV3(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}
