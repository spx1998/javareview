package com.algorithms.classical.dp.bag;

/**
 * 01背包
 * 给你一个可装载重量为W的背包和N个物品，
 * 每个物品有重量和价值两个属性。
 * 其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 */
public class _01KnapsackProblem {
    public static void main(String[] args) {
        System.out.println(new _01KnapsackProblem().max(5, 4, new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}));
    }

    /**
     * 空间复杂度wn，空间复杂度wn
     */
    public int max(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= wt[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - wt[j - 1]][j - 1] + val[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[w][n];
    }

    /**
     * 解法2：滚动数组优化空间复杂度
     */
    public int max2(int w, int n, int[] wt, int[] val) {
        int[] dp = new int[w + 1];
//       一定要把对n的遍历放在外层
        for (int j = 0; j < n; j++) {
//            优化后的内层循环必须是逆序遍历的
//            以上两个限制保证不会重复使用某个wt[i]
            for (int i = w; i >= 0; i--) {
                if (i - wt[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[w];
    }

}
