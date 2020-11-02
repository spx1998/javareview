package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * *        0
 * *       / \
 * *     -3   9
 * *     /   /
 * *   -10  5
 */
public class Solution108 {
    public static void main(String[] args) {
        new Solution108().sortedArrayToBST(new int[]{-10, -13, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return addNode(nums, 0, nums.length - 1);
    }

    private TreeNode addNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = addNode(nums, start, mid - 1);
        root.right = addNode(nums, mid + 1, end);
        return root;
    }
}
