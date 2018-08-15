package algorithms.leetcode;

public class SpiralMatrix2 {

    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output:
     * [
     * [ 1,  2,  3,  4],
     * [ 12, 13, 14, 5],
     * [ 11, 16, 15, 6],
     * [ 10, 9,  8,  7]
     * ]
     */

    //旋转坐标法
    public int[][] generateMatrix(int n) {

        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int[][] ans = new int[n][n];
        int r0=0,c0=0,count=1;
        ans[r0][c0]=count;
        count++;
        if (n == 1) return ans;
        for (int k = n; k >= 1; k -= 2) {
            for (int i = 0; i < 4; i++) {  // i: direction index
                int dk = k - (i+1)/2;  // number of steps in this direction
                for (int j = 0; j < dk;j++) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (r0<0||r0>=n||c0<0||c0>=n) {
                        r0 -= dr[i];
                        c0 -= dc[i];
                        break;
                    }
                    ans[r0][c0] = count;
                    count++;
                }
            }
        }
        return ans;
    }

    //直接按顺时针方向滑动遍历
    public static int[][] generateMatrixV2(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }
}
