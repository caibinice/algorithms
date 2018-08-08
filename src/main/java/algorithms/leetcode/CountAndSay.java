package algorithms.leetcode;

public class CountAndSay {

    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth term of the count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * Example 1:
     * <p>
     * Input: 1
     * Output: "1"
     * Example 2:
     * <p>
     * Input: 4
     * Output: "1211"
     */

    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        if (n == 2) return "11";
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder("");
        char[] chars = last.toCharArray();
        int count = 1;
        char lastChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != lastChar) {
                sb.append(count + "" + Character.toString(lastChar));
                lastChar = chars[i];
                count = 1;
            } else {
                count++;
            }
            if (i == chars.length - 1) {
                sb.append(count + "" + Character.toString(lastChar));
            }
        }
        return sb.toString();
    }
}
