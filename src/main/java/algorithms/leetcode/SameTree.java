package algorithms.leetcode;

public class SameTree {

/**
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical
    and the nodes have the same value.

            Example 1:

    Input:     1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:     1         1
            /           \
            2             2

            [1,2],     [1,null,2]

    Output: false*/

/**
 * Definition for a binary tree node.
 * */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean pNull = p == null;
        boolean qNull = q == null;
        if (pNull && qNull) return true;
        if (qNull||pNull||(p.val!=q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
