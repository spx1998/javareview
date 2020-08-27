package com.algorithms.leetcode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入只包括小写字母a-z。
 *
 * 我的解法：纵向依次比较
 * 二分查找解法：是直接比较的优化
 * 排序解法：
 * 将数组排序，然后比较第一个和最后一个元素。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strs==null||strs.length==0) {
            return "";
        }
        int i = 0;
        while (i<strs[0].length()) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if(strs[j].length()<=i||strs[j].charAt(i)!=c){
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
            i++;
        }
        return stringBuilder.toString();
    }
}
