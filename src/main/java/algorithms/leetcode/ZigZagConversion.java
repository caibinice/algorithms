package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     * Example 1:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    public String convert(String s, int numRows) {
        if (s == null) return null;
        int len = s.length();
        if (len < 3) return s;
        if (numRows <= 1) return s;
        int interval = 2 * numRows - 2;
        int count = len / interval;
        int mod = len % interval;
        char[] result = new char[len];
        //计算每一行之前累计所占的index
        int[] lineNoToElements = new int[numRows];
        lineNoToElements[0] = 0;
        for (int i = 1; i < numRows; i++) {
            int sum = lineNoToElements[i - 1];
            if (i == 1) {
                sum = sum + count;
                if (mod > 0) {
                    sum++;
                }
            } else {
                sum = sum + 2 * count;
                if (mod > i - 1) {
                    sum++;
                }
                if (mod - numRows + i >= numRows) {
                    sum++;
                }
            }
            lineNoToElements[i] = sum;
        }

        for (int i = 0; i <= count; i++) {
            for (int j = 0; j < interval; j++) {
                int originIndex = i * interval + j;
                if (originIndex >= len) break;
                int convertIndex = 0, line = 0;
                if (j < numRows) {
                    line = j;
                } else {
                    line = interval - j;
                    convertIndex++;
                }
                convertIndex += lineNoToElements[line];
                if (j == 0 || j == numRows - 1) {
                    convertIndex += i;
                } else {
                    convertIndex += 2 * i;
                }
                result[convertIndex] = s.charAt(originIndex);
            }
        }
        return new String(result);
    }

    //官方版本
    public String convertV2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    //官方版本
    public String convertV3(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}
