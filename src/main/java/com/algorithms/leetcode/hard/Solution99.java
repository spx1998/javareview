package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
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
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                if (root.left != null &&) {

                }
                root = root.left;
            }
            root = stack.pop().right;
        }
    }
}
