package algorithms.leetcode;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: "{[]}"
     * Output: true
     */
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) return true;
        int len = s.length();
        if (len % 2 != 0) return false;
        char[] array = new char[len];//模拟栈结构
        int start = -1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                start++;
                array[start] = c;
            } else {
                if (start<0) return false;
                if (c == ')' && array[start] != '(') return false;
                if (c == ']' && array[start] != '[') return false;
                if (c == '}' && array[start] != '{') return false;
                start --;
            }
        }
        return start==-1;
    }

    //更简洁的版本
    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("([)]"));
    }
}
