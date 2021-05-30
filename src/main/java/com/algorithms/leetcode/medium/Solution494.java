package com.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * 约定：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 */
public class Solution494 {
    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    /**
     * 暴力解法
     */
    public int findTargetSumWays0(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(nums[0], 1);
        map1.put(-nums[0], map1.getOrDefault(-nums[0], 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            for (Integer integer : map1.keySet()) {
                map2.put(integer + nums[i], map1.getOrDefault(integer, 0) + map2.getOrDefault(integer + nums[i], 0));
                map2.put(integer - nums[i], map1.getOrDefault(integer, 0) + map2.getOrDefault(integer - nums[i], 0));
            }
            Map<Integer, Integer> temp = map1;
            map1 = map2;
            map2 = temp;
            map2.clear();
        }
        return map1.getOrDefault(target, 0);
    }

    /**
     * 转换为01背包的恰好装满问题：
     * sum = m + n;
     * target = m - n;
     * sum+target = 2 * m;
     * m = (sum+target)/2;
     * 求得存在这样的m（nums中x个元素的和），则存在题设中的方案；
     * 求得m的方案的个数即题解。
     * <p>
     * 需要注意两点：（下面的target是计算得出的01背包问题的target不是入参的target）
     * 1）初始化：本题可以转化到恰好装满的case.但是在初始化时dp[0][0]初始化为1，表示nums中没有元素，target为0时只有一种方案即什么也不选，其他元素初始化为0而不是Integer.MIN_VALUE；
     * 2）第一行不可以直接跳过需要遍历计算，因为target为0是有意义的，且可能不只有一种方案.
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) / 2;
        int[][] dp = new int[target + 1][nums.length + 1];
//        1)
        dp[0][0] = 1;
//        2)
        for (int i = 0; i < target + 1; i++) {
            for (int j = 1; j < nums.length + 1; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= nums[j - 1]) {
                    dp[i][j] += dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[target][nums.length];
    }
}
