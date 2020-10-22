package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个整数 n，生成所有由 1 ...n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * 提示：
 * 0 <= n <= 8
 */
public class Solution95 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        new Solution95().add(root, 1);
        new Solution95().generateTrees(3);
    }

    Map<Integer, List<TreeNode>> treeNodeHashMap = new HashMap<>();
    boolean first = true;

    public List<TreeNode> generateTrees(int n) {
        if (n == 0 && first) {
            return new ArrayList<>();
        }
        first = false;
        if (n == 0) {
            treeNodeHashMap.putIfAbsent(0, Collections.singletonList(null));
            return treeNodeHashMap.get(0);
        }
        if (n == 1) {
            treeNodeHashMap.putIfAbsent(1, Collections.singletonList(new TreeNode(1)));
            return treeNodeHashMap.get(1);
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.addAll(generateTrees(i, n));
        }
        return list;
    }

    private List<TreeNode> generateTrees(int i, int n) {
        if (treeNodeHashMap.get(i - 1) == null) {
            treeNodeHashMap.put(i - 1, generateTrees(i - 1));
        }
        if (treeNodeHashMap.get(n - i) == null) {
            treeNodeHashMap.put(n - i, generateTrees(n - i));
        }
        List<TreeNode> list = new ArrayList<>();
        TreeNode root;
        for (int x = 0; x < treeNodeHashMap.get(i - 1).size(); x++) {
            for (int y = 0; y < treeNodeHashMap.get(n - i).size(); y++) {
                root = new TreeNode(i);
                root.left = treeNodeHashMap.get(i - 1).get(x);
                root.right = add(treeNodeHashMap.get(n - i).get(y), i);
                list.add(root);
            }
        }
        treeNodeHashMap.computeIfAbsent(n, k -> new ArrayList<>());
        treeNodeHashMap.get(n).addAll(list);

        return list;
    }

    private TreeNode add(TreeNode treeNode, int add) {
        if (treeNode == null) {
            return null;
        }
        TreeNode root = null;
        TreeNode temp = null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                if (root == null) {
                    root = new TreeNode(treeNode.val + add);
                    temp = root;
                }
                stack.push(treeNode);
                stack1.push(temp);
                treeNode = treeNode.left;
                if (treeNode != null) {
                    temp.left = new TreeNode(treeNode.val + add);
                    temp = temp.left;
                }
            }
            treeNode = stack.pop();
            treeNode = treeNode.right;
            temp = stack1.pop();
            if (treeNode != null) {
                temp.right = new TreeNode(treeNode.val + add);
                temp = temp.right;
            }
        }
        return root;
    }

}
/*
if (n == 0) {
        return treeNodeHashMap.get(0);
        }
        if (n - i == 1) {
        return treeNodeHashMap.get(1);
        }


        }

        return ;*/
