package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 我的解法：
 * 依照题意删除重复元素即可。
 * 相关问题：
 * leetcode 82题 {@link com.algorithms.leetcode.medium.Solution82}
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}
