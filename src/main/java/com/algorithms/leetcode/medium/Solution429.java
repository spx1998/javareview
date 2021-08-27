package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 */
public class Solution429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                integers.add(poll.val);
                queue.addAll(poll.children);
            }
            lists.add(integers);
        }
        return lists;
    }
}
