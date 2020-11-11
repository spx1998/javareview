package com.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 杨辉三角：
 * *     1
 * *    1 1
 * *   1 2 1
 * *  1 3 3 1
 * * 1 4 6 4 1
 *
 * 解法：
 * 其实是动态规划的思想.
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        result.add(Collections.singletonList(1));
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = result.get(i - 1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                newList.add(list.get(j) + list.get(j + 1));
            }
            newList.add(1);
            result.add(newList);
        }
        return result;
    }
}
