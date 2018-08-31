package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

    /**
     * Version 1
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 5
     * Output:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if (numRows == 0) return ans;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * Version 2
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.In Pascal's triangle,
     * each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: [1,3,3,1]
     * Follow up:
     * <p>
     * Could you optimize your algorithm to use only O(k) extra space?
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans.get(rowIndex);
    }

    //O(1) space
    public List<Integer> getRowV2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

}
