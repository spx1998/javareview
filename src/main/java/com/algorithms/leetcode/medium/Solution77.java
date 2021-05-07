package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 我的解法：
 * 回溯法
 * 优化：
 * 剪枝
 *
 *
 * 相关问题：
 * leetcode第39题 {@link Solution39}
 * leetcode第40题 {@link Solution40}
 * leetcode第77题 {@link Solution77}
 * leetcode第216题 {@link Solution216}
 */
public class Solution77 {
    public static void main(String[] args) {
        new Solution77().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int i, int n, int k, ArrayList<Integer> list, List<List<Integer>> lists) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
//        剪枝
        if (k - list.size() > n - i + 1) {
            return;
        }
        if (i <= n) {
            list.add(i);
            dfs(i + 1, n, k, list, lists);
            list.remove(list.size() - 1);
            dfs(i + 1, n, k, list, lists);
        }
    }

    /**
     * 非递归的方式，二进制模拟 当前数被选中为1，未选中为0，则问题转换为一个n位的二进制数字，k位为1，n-k位为0，共几种可能。
     * 规则：
     * 1)如果低位起是连续的t位1，则将倒数第t位的1与第t+1位的0换位；
     * 2)如果低位起是连续的t位0，然后是连续的m位1，则倒数第m+t位的1与m+t+1位的0换位，倒数第t+1位到t+m-1位的1移动到低位。
     * 规则1是规则2在低位0的个数为0时的特例。
     * temp[i]+1 = temp[i+1]说明 i+1 位为1，否则i+1位为0。
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
//        初始化第一种情况 0…01…1 k位1都在最低位.
        for (int i = 1; i <= k; i++) {
            temp.add(i);
        }
        result.add(new ArrayList<>(temp));
        while (temp.get(0) != n - k + 1) {
            int i = 0;
//            其实都是规则2，因为规则1是2的特例
            while (i != temp.size() - 1 && temp.get(i + 1) == temp.get(i) + 1) {
                i++;
            }
            if (temp.get(i) != n) {
                temp.set(i, temp.get(i) + 1);
            }
            for (int j = 0; j <= i - 1; j++) {
                temp.set(j, j + 1);
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}
