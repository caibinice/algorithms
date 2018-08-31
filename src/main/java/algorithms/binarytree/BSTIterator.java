package algorithms.binarytree;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class BSTIterator {

    Stack<TreeNode> stack = null;
    TreeNode current = null;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode t = stack.pop();
        current = t.right;
        return t.val;
    }
}
