package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1, 3, 4]
 * 解释:
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int temp = 0;
            int size = nodes.size();
            TreeNode poll = null;
            while (temp < size) {
                poll = nodes.poll();
                temp++;
                if (poll.left != null) {
                    nodes.offer(poll.left);
                }
                if (poll.right != null) {
                    nodes.offer(poll.right);
                }
            }
            result.add(poll.val);
        }
        return result;
    }
}
