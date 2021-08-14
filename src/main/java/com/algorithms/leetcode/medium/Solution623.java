package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第d层追加一行值为v的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为v的左子树和右子树。
 * 将N 原先的左子树，连接为新节点v 的左子树；将N 原先的右子树，连接为新节点v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * TODO
 */
public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        } else {
           /* Queue<> queue = new LinkedList();
            int cur = 0;
            while (!queue.isEmpty()) {

            }*/
        }
        return null;
    }
}
