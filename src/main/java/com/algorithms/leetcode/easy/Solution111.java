package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * 我的解法：DFS
 * 其他解法：BFS 层序遍历。
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 && right == 0) {
                return 1;
            } else if (left == 0 || right == 0) {
                return Math.max(left, right) + 1;
            } else {
                return Math.min(left, right) + 1;
            }
        }
    }
}
