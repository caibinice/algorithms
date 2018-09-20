package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal {

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
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
     * Output: [3,2,1]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    //DFS
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<TreeNode> tree = new Stack<>();
        TreeNode cur, pre = null;
        tree.push(root);
        while (!tree.isEmpty()) {
            cur = tree.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && ((pre == cur.left && cur.right == null) || pre == cur.right))) {
                ans.add(cur.val);
                tree.pop();
                pre = cur;
            } else {
                if (cur.right != null) tree.push(cur.right);
                if (cur.left != null) tree.push(cur.left);
            }
        }
        return ans;
    }

    //和前序遍历相反的步骤
    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    //模仿前序遍历，仅是添加list的顺序相反
    public List<Integer> postorderTraversalV3(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ret.add(0, curr.val);
            if (curr.left != null)
                stack.push(curr.left);
            if (curr.right != null)
                stack.push(curr.right);
        }

        return ret;
    }

}
