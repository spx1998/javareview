package com.algorithms.leetcode.hot100;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class _20ValidParentheses {
    public static void main(String[] args) {
        new _20ValidParentheses().isValid("()");
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character pop = stack.pop();
            if ((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop != '{')) {
                return false;
            }
        }
        return stack.empty();
    }
}
