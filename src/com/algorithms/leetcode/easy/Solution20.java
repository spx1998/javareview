package com.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 我的解法：
 * 建立一个空的char stack，遍历字符串中的字符，如果是左括号则入栈，如果是右括号则进行判断：
 * 1.stack为空，结果为false。
 * 2.栈顶元素为左括号，但与该右括号不匹配，结果为false。
 * 3.栈顶元素为左括号，且与该右括号匹配，取除栈顶元素，从字符串中的下一字符继续进行匹配。
 * 对字符串完成遍历且stack为空，则结果为true，否则输出false。
 *
 * 改进：
 * 1.若chars长度为奇数，直接输出false。
 * 2.若stack深度大于chars长度的一半，直接输出false。
 */
public class Solution20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            } else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
