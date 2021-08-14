package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)
 * 和(row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，
 * 形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 */
public class Solution987 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        new Solution987().verticalTraversal(treeNode);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Map<Integer, List<Integer>>> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int min = 0;
        if (root == null) {
            return res;
        }
        Map<TreeNode, Integer> nodeColMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        temp.add(new HashMap<>());
        temp.get(0).put(0, new ArrayList<>());
        temp.get(0).get(0).add(root.val);
        nodeColMap.put(root, 0);
        queue.offer(root);
        int tempCount = 0;
        int rowSize = 1;
        int row = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer col = nodeColMap.get(poll);
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if (poll.left != null) {
                if (col - 1 < min) {
                    temp.add(0, new HashMap<>());
                    min = col - 1;
                }
                temp.get(col - 1 - min).putIfAbsent(row, new ArrayList<>());
                temp.get(col - 1 - min).get(row).add(left.val);
                nodeColMap.put(left, col - 1);
                queue.offer(left);
            }
            if (right != null) {
                if (col + 1 > min + temp.size() - 1) {
                    temp.add(temp.size(), new HashMap<>());
                }
                temp.get(col + 1 - min).putIfAbsent(row, new ArrayList<>());
                temp.get(col + 1 - min).get(row).add(right.val);
                nodeColMap.put(right, col + 1);
                queue.offer(right);
            }
            tempCount++;
            if (rowSize == tempCount) {
                rowSize = queue.size();
                tempCount = 0;
                row++;
            }
        }
        temp.forEach(map -> map.values().forEach(list -> list.sort(Comparator.comparingInt(a -> a))));

        return temp.stream().map(map -> {
            ArrayList<Integer> integers = new ArrayList<>(map.keySet());
            Collections.sort(integers);
            ArrayList<Integer> objects = new ArrayList<>();
            for (Integer i : integers) {
                objects.addAll(map.get(i));
            }
            return objects;
        }).collect(Collectors.toList());
    }


}
