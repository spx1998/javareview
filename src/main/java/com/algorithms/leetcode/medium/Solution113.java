package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明:叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 * *               5
 * *              / \
 * *             4   8
 * *            /   / \
 * *           11  13  4
 * *          /  \    / \
 * *         7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * 解法：
 * 同112题
 * <p>
 * 相似问题：
 * leetcode 112 {@link com.algorithms.leetcode.easy.Solution112}
 */
public class Solution113 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (0 == sum) {
                result.add(new ArrayList<>(list));
            }
        }
        pathSum(root.left, sum, list);
        pathSum(root.right, sum, list);
        list.remove(list.size() - 1);
    }
}
