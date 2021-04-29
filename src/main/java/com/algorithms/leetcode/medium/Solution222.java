package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2^h个节点。
 * TODO 题解
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = left(root);
        int right = right(root);
        if (left == right) {
            return (int) Math.pow(2, left) - 1;
        }
        return 1 + DFS(root.left) + DFS(root.right);

    }

    private int right(TreeNode root) {
        int i = 1;
        while ((root = root.right) != null) {
            i++;
        }
        return i;
    }

    private int left(TreeNode root) {
        int i = 1;
        while ((root = root.left) != null) {
            i++;
        }
        return i;
    }
}
