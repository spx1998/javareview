package com.algorithms.leetcode.hot100;

import com.algorithms.datastructure.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class _19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode fast = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return head;
        }
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return sentinel.next;
    }
}
