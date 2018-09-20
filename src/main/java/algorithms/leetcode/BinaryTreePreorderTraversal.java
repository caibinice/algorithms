package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,2,3]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<TreeNode> tree = new Stack<>();
        tree.push(root);
        while (!tree.isEmpty()) {
            TreeNode peek = tree.pop();
            ans.add(peek.val);
            if (peek.right != null) {
                tree.push(peek.right);
            }
            if (peek.left != null) {
                tree.push(peek.left);
            }
        }
        return ans;
    }

}
