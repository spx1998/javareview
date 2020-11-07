package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 * *     1
 * *    / \
 * *   2   5
 * *  / \   \
 * * 3   4   6
 * 将其展开为：
 * 1 2 3 4 5 6
 * 我的解法：
 * 前序遍历树。遍历过程中：
 * 1）交换左右节点位置；
 * 2）如果当期节点无左节点，则将链表最后一个节点的next设为最近的一个右节点。（左右是相对最初的树，即交换前的位置。）
 */
public class Solution114 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        new Solution114().flatten(treeNode);
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                cur = root;
                stack.push(root);
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                root = root.right;
            }
            TreeNode temp = stack.pop();
            root = temp.left;
            temp.left = null;
            if (root != null) {
                cur.right = root;
                cur = cur.right;
            }
        }
    }
}
