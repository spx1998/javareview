package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * 示例 1:
 * 输入:2
 * 输出:[0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1]也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例2:
 * 输入:0
 * 输出:[0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 * 我的解法：
 * 观察可以发现规律：
 * 对于位数n来说，n的序列为n-1的序列加上一个新序列。其中这个新序列应该是n-1的序列中的每个值加2^(n-1),并反转。
 * 例如 n = 3 时：
 * 000 001 011 010 => n-1的序列
 * 110 111 101 100 => n-1的序列中的每个值+n^(3-1),并反转
 */
public class Solution89 {
    public static void main(String[] args) {
        new Solution89().grayCode(3).forEach(System.out::println);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i <= n; i++) {
            result.addAll(doSomething(result, i));
        }
        return result;
    }

    private List<Integer> doSomething(List<Integer> result, int i) {
        List<Integer> list = result.stream().map(o -> o + (int) (Math.pow(2, i - 1))).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }
}
