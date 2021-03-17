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
 * <p>
 * 我的解法：
 * 1）中序遍历二叉查找树的结果，是一个排序的数组，所以遍历一次，找到排序数组中未排序的两个值交换。
 * 2）在中序遍历的过程中同时标记两个错误的节点。两个交换的节点导致一次后面的节点小于前面的节点，如图。
 * *      5          4
 * *    /  \        / \
 * *  3    7 ==>  3    7  一次
 * *   \           \
 * *    4           5
 * *      5          5
 * *    /  \        / \
 * *  3    7 ==>  3    4  两次
 * *   \           \
 * *    4           7
 *
 * 空间复杂度O(1)的解法
 * morris解法 todo
 */
public class Solution99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new Solution99().recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        TreeNode wrongNode1 = null, wrongNode2 = null;
        TreeNode temp = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (temp != null && root.val < temp.val) {
                wrongNode1 = root;
                if (wrongNode2 == null) {
                    wrongNode2 = temp;
                } else {
                    break;
                }
            }
            temp = root;
            root = root.right;
        }
        int val = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = val;
    }
}
