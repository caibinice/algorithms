package algorithms.leetcode;

import java.util.HashMap;

public class LongestCommonSubstr {

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * 示例：
     *
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     *
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     *
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
     */


    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int length = s.length();
        if (length <= 1) return length;
        int maxLen = 0;
        int lastPrefixIndex = 0;
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            Integer lastIndex = charToIndex.get(c);
            if (lastIndex != null && lastIndex >= lastPrefixIndex) {
                if (i - lastPrefixIndex > maxLen) {
                    maxLen = i - lastPrefixIndex;
                }
                lastPrefixIndex = lastIndex + 1;
            }
            charToIndex.put(c, i);
        }
        if (maxLen < length - lastPrefixIndex) {
            maxLen = length - lastPrefixIndex;
        }
        return maxLen;
    }

    //官方解答版本，基于ASCII 128字符集的滑动窗口法
    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
