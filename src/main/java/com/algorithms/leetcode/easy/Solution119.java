package com.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 解法：
 * 同118题，注意用同一个list来装每行的元素。
 * <p>
 * 相关问题：
 * leetcode 118题 {@link Solution118}
 * leetcode 120题 {@link com.algorithms.leetcode.medium.Solution120}
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
//        在题中，忽略了第1行，所以第一行为1 1，第二行为1 2 1 以此类推
        rowIndex = rowIndex + 1;
        List<Integer> list = new ArrayList<>();
        if (rowIndex <= 0) {
            return list;
        }
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            list.add(0, 1);
            list.set(list.size() - 1, 1);
        }
        return list;
    }

}
