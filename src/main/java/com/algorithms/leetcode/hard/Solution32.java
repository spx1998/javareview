package com.algorithms.leetcode.hard;

import java.util.*;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 我的解法：没有想到DP的思路。使用类似左右括号匹配的方法，用stack遍历s中的字符，存储匹配失败的括号下标（包括左右括号。
 * s被匹配失败的括号划分为几部分，其中最长的一部分即所得。时间复杂度为O（nlogn），为list排序的时间复杂度；空间复杂度为O（n）。
 * 我的解法优化：在stack中提前push-1，这样，每次遍历到')'都可以pop一次，如果stack为空，说明')'没有匹配成功，如果stack不为空说明匹配成功。
 * 这样stack中将未匹配的左右括号都存储，就不必进行上述排序下标，查找最长子串的操作。时间复杂度为O(n).
 * <p>
 * DP解法：
 * 先将DP数组初始化为0，然后对于dp[i]，若chars[i]为'('，显然是0，若chars[i]为')"则要讨论是'…（）…'的情况还是'…））…'的情况。
 * 若是第一种情况，dp[i] = dp[i-2]+2, 对于第二种情况，若chars[i-dp[i-1]]是'（'，即成功匹配时dp[i] = dp[i-dp[i-1]-2]+dp[i-1]+2
 * （dp[i-dp[i-1]-2]是匹配到的'（'之前的匹配成功串的长度，dp[i-1]是'（）'之前的匹配串长度，2是此时匹配的'（）'），若匹配失败，则为0。
 *
 * 不需要格外空间的解法：
 * 设置左右两个计数器，遍历到左右括号时分别+1，若左右计数器值相等，则计算此时的匹配子串长度，若右计数器大于左，则将两计数器都归零。
 * 这样的做法会忽略（（）的情况，则再从右到左遍历一次。
 * 详见： https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 */
public class Solution32 {
    public static void main(String[] args) {
        new Solution32().longestValidParentheses("())");
    }

    /**
     * dp解法
     */
    public int longestValidParenthesesDP(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        //i=0，dp一定为0，跳过可以避免边界溢出的问题
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 我的解法
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                arrayList.add(i);
            }
        }
        ArrayList<Integer> finalList = new ArrayList<>(stack);
        finalList.addAll(arrayList);
        Collections.sort(finalList);
        Iterator<Integer> integerIterator = finalList.iterator();
        int max = 0;
        int a = -1;
        int b = -1;
        while (integerIterator.hasNext()) {
            b = integerIterator.next();
            max = Math.max(max, b - a - 1);
            a = b;
        }
        max = Math.max(max, s.length() - b - 1);
        return max;
    }

    /**
     * 我的解法优化
     */
    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                //由于最初push的-1，当stack为空说明此时的')'与之前的字符匹配失败，将当前i放入stack中充当-1的作用。
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    //若stack不为空，说明括号匹配成功，i-stack中栈顶的坐标为此时已匹配串的长度。
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
