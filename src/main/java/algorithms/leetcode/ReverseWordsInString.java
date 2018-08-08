package algorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ReverseWordsInString {

    /**
     * Given an input string, reverse the string word by word.
     * <p>
     * Example:
     * <p>
     * Input: "the sky is blue",
     * Output: "blue is sky the".
     * Note:
     * <p>
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     */

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        boolean hasChar = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\n' || c == '\t') {
                if (!hasChar) continue;
                stack.push(s.substring(start, i));
                hasChar = false;
            } else {
                if (!hasChar) {
                    start = i;
                    hasChar = true;
                } else if (i == s.length() - 1) {
                    stack.push(s.substring(start));
                }
            }
        }
        if (stack.isEmpty()) return "";
        StringBuilder sb = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            sb.append(" ");
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    //简洁版本
    public String reverseWordsV2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("   the sky   is    blue"));
    }
}
