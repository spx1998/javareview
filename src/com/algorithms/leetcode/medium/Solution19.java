package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 我的解法：双指针 一个指针指向第一个节点，一个向后移动n次。然后两个指针一起向后移动。若指针2已经指向了null，说明倒数第n个节点是头节点
 * 返回head.next；否则两个指针一起向后移动，第二个指针指向最后一个节点时，第一个指针的next即要移除的节点。
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp1 = head;
        ListNode temp2 = head;
        for (int i = 0; i < n; i++) {
            temp2 = temp2.next;
        }
        if (temp2 == null) {
            return head.next;
        }
        while (temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp1.next.next;
        return head;
    }
}
