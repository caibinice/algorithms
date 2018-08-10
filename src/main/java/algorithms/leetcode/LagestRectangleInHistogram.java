package algorithms.leetcode;

import java.util.Stack;

public class LagestRectangleInHistogram {

    /**
     * Given n non-negative integers representing the histogram's bar height
     * where the width of each bar is 1, find the area of largest rectangle in the histogram.
     * <p>
     * Example:
     * <p>
     * Input: [2,1,5,6,2,3]
     * Output: 10
     */
    //暴力法
    public int largestRectangleAreaV2(int[] heights) {
        int len = heights.length;
        if (len<1) return 0;
        int max=0,l,r;
        for (int i = 0; i < len; i++) {
            l=i;
            r=i;
            while (l-1>=0 && heights[l-1]>=heights[i]) {
                l--;
            }
            while (r+1<len && heights[r+1]>=heights[i]) {
                r++;
            }
            max = Math.max(max, (r-l+1)*heights[i]);
        }
        return max;
    }

    //将元素递增插入栈中
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);//末尾插入0以让所有元素出栈
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                //如果比上一个元素小，则出栈并更新maxArea。并将i--，这样继续出栈，直到遇到比该元素小的数
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] h = {2,3,3,3,3};
        System.out.println(new LagestRectangleInHistogram().largestRectangleAreaV2(h));
    }
}
