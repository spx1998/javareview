package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * 我的解法：
 * 回溯法
 *
 * 相关问题：
 * leetcode 91题 {@link Solution91}
 */
public class Solution93 {
    public static void main(String[] args) {
        new Solution93().restoreIpAddresses("0000").forEach(System.out::println);
    }

    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, int index, ArrayList<Integer> list, int num) {
        if (list.size() == 4) {
            if (index == s.length()) {
                result.add(generateIpAddr(list));
            }
            return;
        }
        if (index == s.length()) {
            return;
        }
        if (num == 0 && s.charAt(index) == '0') {
            list.add(0);
            dfs(s, index + 1, list, 0);
            list.remove(list.size() - 1);
        } else if (validateNum(s.charAt(index) - 48, num)) {
            int newNum = num * 10 + s.charAt(index) - 48;
            list.add(newNum);
            dfs(s, index + 1, list, 0);
            list.remove(list.size() - 1);
            dfs(s, index + 1, list, newNum);
        }
    }

    private boolean validateNum(int i, int num) {
        return num * 10 + i < 256 && num * 10 + i >= 0;
    }

    private String generateIpAddr(ArrayList<Integer> columns) {
        List<String> collect = columns.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(".", collect);
    }
}
