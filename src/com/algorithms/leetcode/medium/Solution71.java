package com.algorithms.leetcode.medium;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，
 * 一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，
 * 并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 我的解法：利用栈，遍历String转化的char数组。总是使stack满足上述条件即可。
 * 改进：栈可以直接用StringBuilder ,省下反转一步，
 * <p>
 * 更佳解法：应该先将string用split()处理，转化为string数组。再根据题设条件调整（去掉. 有..则去掉..和前一项）。最后连接。
 */
public class Solution71 {

    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (stack.empty() || stack.peek() != '/') {
                    stack.push('/');
                }
            } else if (chars[i] == '.') {
                if (stack.peek() == '/') {
                    if ((i + 1 < chars.length && chars[i + 1] == '/') || i == chars.length - 1) {
                        stack.pop();
                    } else if (chars[i + 1] == '.') {
                        if ((i + 2 < chars.length && chars[i + 2] == '/') || i == chars.length - 2) {
                            stack.pop();
                            while (!stack.empty() && stack.peek() != '/') {
                                stack.pop();
                            }
                            if (!stack.empty()) stack.pop();
                            i++;
                        } else {
                            stack.push('.');
                        }
                    } else {
                        stack.push('.');
                    }
                } else stack.push('.');
            } else stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        if (sb.length() == 0)
            sb.append('/');
        else if (sb.charAt(sb.length() - 1) == '/' && sb.length() != 1)
            sb.deleteCharAt(sb.length() - 1);
        String s = sb.toString();
        if (sb.charAt(0) != '/') {
            s = "/" + s;
        }
        return s;
    }

    public String betterSimplifyPath(String path) {
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(".")) {
                strings[i] = "";
            } else if (strings[i].equals("..")) {
                strings[i] = "";
                int j = i - 1;
                while (j >= 0) {
                    if (!strings[j].equals("")) {
                        strings[j] = "";
                        break;
                    }
                    j--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("/");
        for (String s : strings) {
            if (!s.equals("")) {
                stringBuilder.append(s).append("/");
            }
        }
        if (stringBuilder.length() != 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
