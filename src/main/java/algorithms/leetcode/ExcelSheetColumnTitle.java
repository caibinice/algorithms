package algorithms.leetcode;

public class ExcelSheetColumnTitle {

    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     * <p>
     * For example:
     * <p>
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     * Example 1:
     * <p>
     * Input: 1
     * Output: "A"
     * Example 2:
     * <p>
     * Input: 28
     * Output: "AB"
     * Example 3:
     * <p>
     * Input: 701
     * Output: "ZY"
     */

    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }
}
