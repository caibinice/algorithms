package algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UncommonWordsOfTwoSentences {

    /**
     * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
     * <p>
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     * <p>
     * Return a list of all uncommon words.
     * <p>
     * You may return the list in any order.
     * <p>
     * Example 1:
     * Input: A = "this apple is sweet", B = "this apple is sour"
     * Output: ["sweet","sour"]
     * <p>
     * Example 2:
     * Input: A = "apple apple", B = "banana"
     * Output: ["banana"]
     */

    public String[] uncommonFromSentences(String A, String B) {
        if (A.length() == 0 && B.length() == 0) return new String[0];
        Set<String> resultSet = new HashSet<>();
        Set<String> commonSet = new HashSet<>();
        String c = A + " " + B;
        String[] words = c.split(" +");
        for (int i = 0; i < words.length; i++) {
            if (!resultSet.add(words[i])) {
                commonSet.add(words[i]);
            }
        }
        for (String s : commonSet)
            resultSet.remove(s);
        resultSet.remove("");
        String[] arr = new String[resultSet.size()];
        resultSet.toArray(arr);
        return arr;
    }
}
