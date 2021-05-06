package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明:叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 * *    1
 * *  /   \
 * * 2     3
 * *  \
 * *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        }
        if (root.left != null) {
            preTraverse(root.left, sb, result);
        }
        if (root.right != null) {
            preTraverse(root.right, sb, result);
        }
        return result;
    }

    private void preTraverse(TreeNode root, StringBuilder sb, ArrayList<String> result) {
        sb.append("->").append(root.val);
        if (root.right == null && root.left == null) {
            result.add(sb.toString());
            sb.delete(sb.length() - String.valueOf(root.val).length() - 2, sb.length());

            return;
        }
        if (root.left != null) {
            preTraverse(root.left, sb, result);
        }
        if (root.right != null) {
            preTraverse(root.right, sb, result);

        }
        sb.delete(sb.length() - String.valueOf(root.val).length() - 2, sb.length());
    }
}
