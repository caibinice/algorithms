package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths
     * where each path's sum equals the given sum.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given the below binary tree and sum = 22,
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * Return:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     */

    private int sum0 = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        sum0 = sum;
        backTrack(root, ans, new LinkedList<>(), 0);
        return ans;
    }

    private void backTrack(TreeNode node, List<List<Integer>> ans, List<Integer> list, int sum) {
        if (node == null) return;
        sum += node.val;
        List<Integer> newList = new LinkedList<>(list);
        newList.add(node.val);
        if (sum == sum0 && node.left == null && node.right == null) {
            ans.add(newList);
        } else {
            if (node.left != null) backTrack(node.left, ans, newList, sum);
            if (node.right != null) backTrack(node.right, ans, newList, sum);
        }
    }
}
