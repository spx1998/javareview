package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 我的解法：
 * 依据题意交换即可。值得注意的是，通过设置一个pre指针，将链表前两个节点的交换泛化成为其他节点交换的情况。
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre;
        while (head != null && head.next != null) {
            ListNode cur = head.next.next;
            temp.next = head.next;
            head.next.next = head;
            head.next = cur;
            temp = head;
            head = cur;

        }
        return pre.next;
    }
}
