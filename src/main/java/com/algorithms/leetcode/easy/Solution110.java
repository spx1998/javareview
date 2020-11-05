package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * 我的解法：
 * 递归 遍历二叉树，对于每个节点求左右子树的高度，相差超过一则整个树非平衡二叉树。
 */
public class Solution110 {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (isBalanced) {
            if (root == null) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if (Math.abs(left - right) >= 2) {
                isBalanced = false;
            }
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
}
