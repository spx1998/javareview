package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的后序遍历。要求使用迭代算法。
 * <p>
 * 我的解法：
 * 前序是 前 左 右
 * 后序是 左 右 前
 * 把后序反转就是 前 右 左
 * 可见，把前序算法中提及的左枝都变成右枝，右枝变左枝，最后反转一次就是后序遍历。
 * <p>
 * 解法2：
 * 对于每个节点：若左子节点未遍历则遍历左子节点，若左子节点已遍历则遍历右子节点，若左右子节点都已遍历，则遍历该节点。
 */
public class Solution145 {

    /**
     * 解法1
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop().left;
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 解法2
     */
    public List<Integer> postOrderIteration2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        TreeNode peek;
        TreeNode cur = root;
        while (!stack.empty()) {
            peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                cur = stack.pop();
                list.add(cur.val);
            }
        }
        return list;
    }
}
