package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * *     3
 * *    / \
 * *   9  20
 * *    /  \
 * *  15   7
 * 返回其层次遍历结果：
 * [ [3],
 * [9,20],
 * [15,7] ]
 */
public class Solution102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        List<List<Integer>> lists = new Solution102().levelOrder(root);
        System.out.println();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        int capacity = 1;
        int newCap = 0;
        int count = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root != null) {
                queue.offer(root.left);
                queue.offer(root.right);
                integers.add(root.val);
                newCap++;
            }
            count++;
            if (count == capacity) {
                if (integers.size() != 0) {
                    result.add(integers);
                }
                integers = new ArrayList<>();
                capacity = newCap << 1;
                count = 0;
                newCap = 0;
            }

        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
