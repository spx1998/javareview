package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * *     3
 * *    / \
 * *   9  20
 * *    /  \
 * *  15   7
 * 返回它的最大深度3 。
 *
 * 解法：
 * 1） 递归
 * 2） 层序遍历
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        int height = 0;
        if (root == null) {
            return height;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int size = 1;
        int temp = 0;
        while (!deque.isEmpty()) {
            root = deque.removeFirst();
            temp++;
            if (root.left != null) {
                deque.addLast(root.left);
            }
            if (root.right != null) {
                deque.addLast(root.right);
            }
            if (temp == size) {
                height++;
                size = deque.size();
                temp = 0;
            }
        }
        return height;
    }
}
