package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例2:
 * 输入:
 * *     5
 * *    / \
 * *   1   4
 * *  / \
 * * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 解法：
 * 中序遍历，递归或迭代。
 */
public class Solution98 {
    public static void main(String[] args) {
        System.out.println((long) Integer.MAX_VALUE + 1);
        System.out.println(new Solution98().isValidBST(new TreeNode(Integer.MIN_VALUE)));
    }

    /**
     * 递归
     */
    public boolean isValidBST(TreeNode root) {
        return judge(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    /**
     * 要转换为long，否则判断值为Integer.MIN_VALUE或Integer.MAX_VALUE的节点会出错。
     */
    private boolean judge(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min) {
            return judge(root.left, min, root.val) && judge(root.right, root.val, max);
        }
        return false;
    }

    /**
     * 迭代
     * 二叉搜索树中序遍历的结果应该是一个排序的数组。
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long max = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= max) {
                return false;
            }
            max = root.val;
            root = root.right;

        }
        return true;
    }
}
