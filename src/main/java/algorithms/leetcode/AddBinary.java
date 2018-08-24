package algorithms.leetcode;

public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * <p>
     * The input strings are both non-empty and contains only characters 1 or 0.
     * <p>
     * Example 1:
     * <p>
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     * <p>
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        int[] ans = new int[len];
        int tmp;
        for (int i = 0; i < len; i++) {
            if (i < a.length()) {
                ans[i] += Integer.parseInt(String.valueOf(a.charAt(a.length() - i - 1)));
            }
            if (i < b.length()) {
                ans[i] += Integer.parseInt(String.valueOf(b.charAt(b.length() - i - 1)));
            }
            tmp = ans[i];
            ans[i] = tmp % 2;
            if (tmp > 1) ans[i + 1] += tmp / 2;
        }
        if (ans[len - 1] == 0) len--;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            sb.append(ans[len - 1 - i]);
        }
        return sb.toString();
    }

    public String addBinaryV2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
