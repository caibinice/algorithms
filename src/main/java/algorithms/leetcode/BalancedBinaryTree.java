package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

public class BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * <p>
     * For this problem, a height-balanced binary tree is defined as:
     * <p>
     * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example 1:
     * <p>
     * Given the following tree [3,9,20,null,null,15,7]:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * Return true.
     * <p>
     * Example 2:
     * <p>
     * Given the following tree [1,2,2,3,3,null,null,4,4]:
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * Return false.
     */

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
