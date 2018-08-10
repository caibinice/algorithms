package algorithms.leetcode;

public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * <p>
     * Example:
     * <p>
     * Input: "Hello World"
     * Output: 5
     */
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        int len = s.length();
        int slen = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (slen != 0) return slen;
            } else {
                slen++;
            }
        }
        return slen;
    }

    public int lengthOfLastWordV2(String s) {
        String[] strs = s.split("\\s+");
        return strs.length == 0 ? 0 : strs[strs.length - 1].length();

        //return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
