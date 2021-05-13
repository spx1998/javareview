package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

/**
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从1 到n各不相同。
 * 游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
 * 「一号」玩家从 [1, n]中取一个值x（1 <= x <= n）；
 * 「二号」玩家也从[1, n]中取一个值y（1 <= y <= n）且y != x。
 * 「一号」玩家给值为x的节点染上红色，而「二号」玩家给值为y的节点染上蓝色。
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个y值可以确保你赢得这场游戏，则返回true；若无法获胜，就请返回 false。
 */
public class Solution1145 {
    int a;
    int b;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        DFS(root, x);
        return a > n / 2 || b > n / 2 || (n - 1 - a - b) > n / 2;
    }

    private int DFS(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int dfs1 = DFS(root.left, x);
        int dfs2 = DFS(root.right, x);
        if (root.val == x) {
            a = dfs1;
            b = dfs2;
        }
        return dfs1 + dfs2 + 1;
    }
}
