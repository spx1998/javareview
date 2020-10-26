package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * *     1
 * *    / \
 * *   2   2
 * *  / \ / \
 * * 3  4 4  3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * *     1
 * *    / \
 * *   2   2
 * *    \   \
 * *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Solution101 {
    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    /**
     * 迭代
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution101().isSymmetric2(root));
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> integerList = new ArrayList<>();
        int count = 0;
        int capacity = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                count++;
                integerList.add(node.val);
            } else {
                integerList.add(null);
            }
            if (integerList.size() == capacity) {
                for (int i = 0; i < integerList.size() / 2; i++) {
                    if (!Objects.equals(integerList.get(i), integerList.get(integerList.size() - 1 - i))) {
                        return false;
                    }
                }
                integerList = new ArrayList<>();
                capacity = count << 1;
                count = 0;
            }
        }

        return integerList.size() == 0;
    }
}
