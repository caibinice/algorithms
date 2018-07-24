package algorithms.leetcode;

import java.util.HashMap;

public class MaxArea {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 注意：你不能倾斜容器，n 至少是2。
     */

    //暴力法
//     public int maxArea(int[] height) {
//         int max=0;
//         for (int i=0;i<height.length-1;i++){
//             for(int j=i+1;j<height.length;j++) {
//                 int s = Math.min(height[i],height[j]) * (j-i);
//                 if (s>max) max =s;
//             }
//         }
//         return max;
//     }

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int left = height[start];
            int right = height[end];
            max = Math.max(max, (end - start) * Math.min(left, right));
            if (left < right) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
