package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
 * 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * 我的解法1：
 * hash表存所有可能的子序列
 * TODO 掩码和旋转hash的解法
 */
public class Solution187 {
    public static void main(String[] args) {
        new Solution187().findRepeatedDnaSequences("AAAAAAAAAAA").forEach(System.out::println);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring)) {
                map.put(substring, map.get(substring) + 1);
                set.add(substring);
            } else {
                map.put(substring, 1);
            }
        }
        return new ArrayList<>(set);
    }
}
