package com.algorithms.classical.dp.bag;

/**
 * 完全背包
 * N种物品，其中第i个物品的重量为wt[i]，价值为val[i]，每种物品无限个。
 * 背包承重上限W，装下物品的最大价值
 * <p>
 * 更多变型：
 * 多重背包：物品个数有限，在最内层循环k的边界多一个判断条件，要小于等于i/wt[j-1]和num[j]的较小值;
 * 恰好装满：要求恰好装满背包，不可以有空余。那么只有在背包容量为0时有0解，其他容量初始化为一个不可达的解，如Integer.MIN_VALUE;
 * 求方案总和：max转为sum;
 * 二维背包：如重量限制->长宽限制，dp数组多一个维度;
 * 求最优方案：可以用一个新数组，记录最优解是由转移方程的哪种分支转换过来，也可以拿dp[i][j]与dp[i][j-1]比较判断。
 */
public class UnboundedKnapsackProblem {


    /**
     * 解法1：n^3，时间复杂度不如解法2
     */
    public int max(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                int k = 1;
                while (i - k * wt[j - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - wt[j - 1] * k][j - 1] + val[j - 1] * k);
                    k++;
                }
            }
        }
        return dp[w][n];
    }

    /**
     * 解法2：时间复杂度n^2，空间复杂度可以利用滚动数组继续优化
     * 与解法1的比较，最内层遍历的结果实际就是dp[i - wt[j - 1]][j] + val[j - 1]；
     */
    public int max2(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - wt[j - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - wt[j - 1]][j] + val[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[w][n];
    }

    /**
     * 解法3：滚动数组优化空间占用
     */
    public int max3(int w, int n, int[] wt, int[] val) {
        int[] dp = new int[w + 1];
        for (int j = 0; j < n; j++) {
//            这里与01背包相反，内层遍历必须正向，才能包含所有情况
            for (int i = 0; i <= w; i++) {
                if (i - wt[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[w];
    }
}
