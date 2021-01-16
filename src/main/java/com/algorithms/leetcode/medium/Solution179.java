package com.algorithms.leetcode.medium;

import java.util.ArrayList;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 我的解法：
 * 写一个comparator
 */
public class Solution179 {
    public static void main(String[] args) {
        System.out.println(new Solution179().largestNumber(new int[]{3, 30}));
        System.out.println(new Solution179().largestNumber(new int[]{30, 3}));
    }

    public String largestNumber(int[] nums) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (int num : nums) {
            ints.add(num);
        }
        ints.sort((a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            char[] charsA = String.valueOf(a).toCharArray();
            char[] charsB = String.valueOf(b).toCharArray();
            return (b * (int) Math.pow(10, charsA.length) + a) - (a * (int) Math.pow(10, charsB.length) + b);

        });
        StringBuilder sb = new StringBuilder();
        if(ints.get(0)==0){
            return "0";
        }
        for (int num : ints) {
            sb.append(num);
        }
        return sb.toString();
    }
}
