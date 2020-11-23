package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 示例 1：
 * 输入：[1,2,3]
 * *   1
 * *  / \
 * * 2   3
 * 输出：6
 * 示例2：
 * 输入：[-10,9,20,null,null,15,7]
 * *     -10
 * *     / \
 * *    9  20
 * *      / \
 * *     15  7
 * 输出：42
 * 解法：
 * 递归 DFS 注意路径的定义。
 */
public class Solution124 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);
        System.out.println(new Solution124().maxPathSum(treeNode));
    }

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left > 0) {
            max += left;
        }
        if (right > 0) {
            max += right;
        }
        maxValue = Math.max(maxValue, max);
        return root.val + Math.max(0, Math.max(left, right));
    }
}
 
