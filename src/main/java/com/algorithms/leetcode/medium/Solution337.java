package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 * *     3
 * *    / \
 * *   4   5
 * *  / \   \
 * * 1   3   1
 * <p>
 * 输出: 9
 * 解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 * <p>
 * 我的解法：
 * 暴力的DFS， 存在多次重复计算
 * 优化：
 * 记忆化，把计算过的结果记录下来.
 * <p>
 * 再优化：
 * 树形DP
 */
public class Solution337 {

    Map<TreeNode, Integer> rememberedMap = new HashMap<>();

    {
        rememberedMap.put(null, 0);
    }

    public int rob0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = rob0(root.left);
        int rightVal = rob0(root.right);
        int ll = root.left == null ? 0 : rememberedMap.get(root.left.left);
        int lr = root.left == null ? 0 : rememberedMap.get(root.left.right);
        int rl = root.right == null ? 0 : rememberedMap.get(root.right.left);
        int rr = root.right == null ? 0 : rememberedMap.get(root.right.right);

        int max = Math.max(leftVal + rightVal, root.val + ll + lr + rl + rr);
        rememberedMap.put(root, max);
        return max;
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }


}
