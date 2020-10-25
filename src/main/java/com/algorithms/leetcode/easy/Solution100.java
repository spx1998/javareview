package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

import java.util.Stack;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例1:
 * 输入:
 * *           1         1
 * *          / \       / \
 * *         2   3     2   3
 * *        [1,2,3],   [1,2,3]
 * 输出: true
 * 示例 2:
 * 输入:
 * *           1          1
 * *          /           \
 * *         2             2
 * *        [1,2],     [1,null,2]
 * 输出: false
 * 示例3:
 * 输入:
 * *           1         1
 * *          / \       / \
 * *         2   1     1   2
 * *        [1,2,1],   [1,1,2]
 * 输出: false
 */
public class Solution100 {

    /**
     * 递归
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    /**
     * 迭代
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        while (!stackP.isEmpty() || p != null || q != null) {
            while (p != null) {
                if (q == null || p.val != q.val) {
                    return false;
                }
                stackQ.push(q);
                stackP.push(p);
                p = p.left;
                q = q.left;
            }
            if (q != null) {
                return false;
            }
            p = stackP.pop();
            q = stackQ.pop();
            p = p.right;
            q = q.right;
        }
        return true;
    }
}
