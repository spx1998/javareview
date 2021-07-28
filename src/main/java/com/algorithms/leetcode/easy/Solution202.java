package com.algorithms.leetcode.easy;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 解法：快慢指针
 */
public class Solution202 {

    public static void main(String[] args) {
        new Solution202().isHappy(19);
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    private int next(int num) {
        int result = 0;
        while (num != 0) {
            result += (num % 10) * (num % 10);
            num = num / 10;
        }
        return result;
    }
}
