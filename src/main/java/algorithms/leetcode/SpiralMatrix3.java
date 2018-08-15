package algorithms.leetcode;

public class SpiralMatrix3 {

    /**
     * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
     * <p>
     * Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.
     * <p>
     * Now, we walk in a clockwise spiral shape to visit every position in this grid.
     * <p>
     * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.)
     * <p>
     * Eventually, we reach all R * C spaces of the grid.
     * <p>
     * Return a list of coordinates representing the positions of the grid in the order they were visited.
     * <p>
     * Example 1:
     * Input: R = 1, C = 4, r0 = 0, c0 = 0
     * Output: [[0,0],[0,1],[0,2],[0,3]]
     */

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int[][] ans = new int[R * C][2];
        int t = 0;

        ans[t++] = new int[]{r0, c0};
        if (R * C == 1) return ans;

        for (int k = 1; k < 2 * (R + C); k += 2)
            for (int i = 0; i < 4; ++i) {  // i: direction index
                int dk = k + (i / 2);  // number of steps in this direction
                for (int j = 0; j < dk; ++j) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        ans[t++] = new int[]{r0, c0};
                        if (t == R * C) return ans;
                    }
                }
            }
        throw null;
    }
}
