package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return all possible palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        backTrack(ans, new LinkedList<>(), s);
        return ans;
    }

    private boolean checkPalindrome(String s) {
        if (s == null) return true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }

    private void backTrack(List<List<String>> ans, List<String> list, String s) {
        if (s == null) return;
        int len = s.length();
        if (len == 0) {
            ans.add(list);
            return;
        }
        for (int i = 1; i < len + 1; i++) {
            String sub = s.substring(0, i);
            if (!checkPalindrome(sub))
                continue;
            List<String> newList = new LinkedList<>(list);
            newList.add(sub);
            backTrack(ans, newList, s.substring(i));
        }
    }

}
