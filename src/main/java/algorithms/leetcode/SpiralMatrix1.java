package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null) return ans;
        int row = matrix.length;
        if (row == 0) return ans;
        int col = matrix[0].length;
        if (col == 0) return ans;
        int left = 0,top = 0;
        int right = col -1,down = row - 1;
        int count=0;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ans.add(matrix[top][j]);
                count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ans.add(matrix[i][right]);
                count++;
            }
            if (count>=col*row) return ans;
            right --;
            for (int j = right; j >= left; j --) {
                ans.add(matrix[down][j]);
                count++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ans.add(matrix[i][left]);
                count++;
            }
            if (count>=col*row) return ans;
            left ++;
        }
        return ans;
    }

    //坐标法
    public List<Integer> spiralOrderV2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

}
