package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * 示例1:
 * 输入: [1,3,null,null,2]
 * *   1
 * *  /
 * * 3
 * * \
 * *  2
 * 输出: [3,1,null,null,2]
 * *   3
 * *  /
 * * 1
 * * \
 * *  2
 * 示例2:
 * 输入: [3,1,4,null,null,2]
 * *   3
 * *  / \
 * * 1   4
 * *    /
 * *   2
 * 输出: [2,1,4,null,null,3]
 * *   2
 * *  / \
 * *1    4
 * *    /
 * *   3
 * 进阶:
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 解法：
 * 中序遍历
 */
public class Solution99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new Solution99().recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
