package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Solution230 {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return doSomething(root, k);
    }

    private int doSomething(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int left = doSomething(root.left, k);
        if (count == k) {
            return left;
        }
        this.count++;
        if (count == k) {
            return root.val;
        }
        int right = doSomething(root.right, k);
        return right;
    }
}
