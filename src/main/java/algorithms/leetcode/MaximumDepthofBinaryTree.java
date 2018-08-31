package algorithms.leetcode;

import algorithms.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {

    /**
     * Given a binary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its depth = 3.
     */

    int maxDept = 0;

    public int maxDepth(TreeNode root) {
        getMax(root, 0);
        return maxDept;
    }

    private void getMax(TreeNode node, int depth) {
        if (node == null) {
            maxDept = Math.max(depth, maxDept);
            return;
        }
        getMax(node.left, depth+1);
        getMax(node.right, depth+1);
    }

    public int maxDepthV2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepthV2(root.left),maxDepthV2(root.right));
    }

    //BFS方法
    public int maxDepthV3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
