package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * *     3
 * *    / \
 * *  9  20
 * *     /  \
 * *  15   7
 * 返回其自底向上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 解法：
 * 中序遍历 reverse结果
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (size == list.size()) {
                result.add(list);
                list = new ArrayList<>();
                size = queue.size();
            }
        }
         Collections.reverse(result);
        return result;
    }
}
