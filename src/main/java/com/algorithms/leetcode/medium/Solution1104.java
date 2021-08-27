package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * 解法：结合完全二叉树的性质
 */
public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        int k = 0;
        int temp = label;
        while (temp != 0) {
            temp = temp / 2;
            k++;
        }
        if (k % 2 == 0) {
            label = new Double(Math.pow(2, k) - 1 - label + Math.pow(2, k - 1)).intValue();
        }
        while (label != 0) {
            list.add(label);
            label = label / 2;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 1) {
                Integer integer = list.remove(i);
                integer = new Double(Math.pow(2, i + 1) - 1 - integer + Math.pow(2, i)).intValue();
                list.add(i, integer);
            }
        }
        return list;
    }
}
