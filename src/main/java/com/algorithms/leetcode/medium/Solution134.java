package com.algorithms.leetcode.medium;

/**
 * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 我的解法：
 * 记录一个新数组，值为gas[i]-cost[i]，从下标某处开始遍历数组，数组元素之和不能小于0，则符合条件；若曾小于0，则从下一下标处重新开始遍历数组。
 * 解法2：
 * 数学推导：<a>https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/</a>
 * 当出现不符合条件的情况时，由解法1中从下一下标处重新开始遍历，转变为从不符合条件处的下一坐标开始遍历。
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            boolean b = true;
            int temp = 0;
            for (int j = i; j < gas.length; j++) {
                temp += gas[j];
                if (temp < 0) {
                    b = false;
//                    解法2对于解法1的优化，相当于剪枝
                    i = j;

                    break;
                }
            }
            for (int j = 0; j < i; j++) {
                if (!b) {
                    break;
                }
                temp += gas[j];
                if (temp < 0) {
                    b = false;
                }
            }
            if (b) {
                return i;
            }
        }
        return res;
    }
}
