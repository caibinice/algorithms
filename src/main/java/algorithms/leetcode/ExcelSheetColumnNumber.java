package algorithms.leetcode;

public class ExcelSheetColumnNumber {

    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     * <p>
     * For example:
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * Example 1:
     * <p>
     * Input: "A"
     * Output: 1
     * Example 2:
     * <p>
     * Input: "AB"
     * Output: 28
     * Example 3:
     * <p>
     * Input: "ZY"
     * Output: 701
     */

    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) return 0;
        int value = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            value += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
        }
        return value;
    }
}
