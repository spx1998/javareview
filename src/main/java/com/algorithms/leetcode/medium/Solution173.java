package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * 提示：
 * next()和hasNext()操作的时间复杂度是O(1)，并使用O(h) 内存，其中h是树的高度。
 * 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 中至少存在一个下一个最小的数。
 */
public class Solution173 {
    /**
     * 中序遍历
     */
    class BSTIterator0 {
        List<Integer> nodes;

        public BSTIterator0(TreeNode root) {
            nodes = new ArrayList<>();
            fillNodes(root);
        }

        private void fillNodes(TreeNode root) {
            if (root != null) {
                fillNodes(root.left);
                nodes.add(root.val);
                fillNodes(root.right);
            }
        }

        public int next() {
            return nodes.remove(0);
        }

        public boolean hasNext() {
            return !nodes.isEmpty();
        }
    }

    /**
     * stack
     */
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            fillStack(root);
        }

        private void fillStack(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }


        public int next() {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                fillStack(pop.right);
            }
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


}
