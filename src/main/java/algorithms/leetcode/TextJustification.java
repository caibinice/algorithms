package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextJustification {

    /**
     * Given an array of words and a width maxWidth, format the text such that
     * each line has exactly maxWidth characters and is fully (left and right) justified.
     *
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
     * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
     *
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     *
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     *
     * Note:
     *
     * A word is defined as a character sequence consisting of non-space characters only.
     * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
     * The input array words contains at least one word.
     * Example 1:
     *
     * Input:
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     * Output:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     *
     * Example 2:
     *
     * Input:
     * words = ["What","must","be","acknowledgment","shall","be"]
     * maxWidth = 16
     * Output:
     * [
     * "What   must   be",
     * "acknowledgment  ",
     * "shall be        "
     * ]
     * Explanation: Note that the last line is "shall be    " instead of "shall     be",
     * because the last line must be left-justified instead of fully-justified.
     * Note that the second line is also left-justified becase it contains only one word.
     *
     */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int nowLen = 0;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int wLen = words[i].length();
            if (nowLen == 0) {
                nowLen = wLen;
                queue.offer(words[i]);
            } else if (nowLen + wLen + 1 > maxWidth) {
                String sb = getString(maxWidth, nowLen, queue);
                ans.add(sb);
                queue.offer(words[i]);
                nowLen = wLen;
            } else {
                queue.offer(words[i]);
                nowLen = nowLen + wLen + 1;
            }
        }
        //最后一行要用不同的策略分配空格
        StringBuilder sb = new StringBuilder("");
        sb.append(queue.poll());
        while (!queue.isEmpty()) {
            sb.append(" ");
            sb.append(queue.poll());
        }
        while (nowLen < maxWidth) {
            sb.append(" ");
            nowLen++;
        }
        ans.add(sb.toString());
        return ans;
    }

    private String getString(int maxWidth, int nowLen, Queue<String> queue) {
        StringBuilder sb = new StringBuilder("");
        int count = queue.size();
        sb.append(queue.poll());
        if (count == 1) {
            while (nowLen < maxWidth) {
                sb.append(" ");
                nowLen++;
            }
        } else {
            int spaceNum = count - 1 + maxWidth - nowLen;
            int perSpace = spaceNum / (count - 1);
            int extra = spaceNum % (count - 1);
            for (int j = 0; j < count - 1; j++) {
                for (int k = 0; k < perSpace; k++) {
                    sb.append(" ");
                }
                if (j < extra) sb.append(" ");
                sb.append(queue.poll());
            }
        }
        return sb.toString();
    }
}
