package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p>
     * Find the total sum of all root-to-leaf numbers.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * 1
     * / \
     * 2   3
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     * Example 2:
     * <p>
     * Input: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * Output: 1026
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     */

    public int sumNumbers(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrack(root, ans, new LinkedList<>());
        int sum = 0;
        for (List<Integer> list : ans) {
            StringBuilder sb = new StringBuilder("");
            for (Integer num : list) {
                sb.append(num + "");
            }
            String number = sb.toString();
            if (number.length() > 0) {
                sum += Integer.valueOf(number);
            }
        }
        return sum;
    }

    private void backTrack(TreeNode node, List<List<Integer>> ans, LinkedList<Integer> list) {
        if (node == null) return;
        LinkedList<Integer> newList = new LinkedList<>(list);
        newList.add(node.val);
        if (node.left == null && node.right == null) {
            ans.add(newList);
        } else {
            if (node.left != null) backTrack(node.left, ans, newList);
            if (node.right != null) backTrack(node.right, ans, newList);
        }
    }

    public int sumNumbersV2(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode n, int s) {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s * 10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }

}
