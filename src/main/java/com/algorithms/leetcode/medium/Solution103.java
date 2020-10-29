package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 * *     3
 * *    / \
 * *   9  20
 * *    /  \
 * *  15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution103 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        new Solution103().zigzagLevelOrder(treeNode);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


    }
}
