package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 相关问题：
 * leetcode 206题 {@link com.algorithms.leetcode.easy.Solution206}
 */
public class Solution92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = listNode;
        next = (next.next = new ListNode(2));
        next = (next.next = new ListNode(3));
        next = (next.next = new ListNode(4));
        next.next = new ListNode(5);
        new Solution92().reverseBetween(listNode, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preTail = null;
        ListNode postHead = head;
        int i = 1;
        while (i <= n) {
            if (i == m - 1) {
                preTail = postHead;
            }
            postHead = postHead.next;
            i++;
        }
        ListNode reverseHead;
        if (preTail != null) {
            reverseHead = preTail.next;
        } else {
            reverseHead = head;
        }
        ListNode temp = reverseHead;
        reverseHead = postHead;
        while (temp != postHead) {
            ListNode next = temp.next;
            temp.next = reverseHead;
            reverseHead = temp;
            temp = next;
        }
        if (preTail != null) {
            preTail.next = reverseHead;
            return head;
        } else {
            return reverseHead;
        }
    }
}
