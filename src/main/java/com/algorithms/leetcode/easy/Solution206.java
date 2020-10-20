package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.ListNode;

/**
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 相关问题：
 * leetcode 92题 {@link com.algorithms.leetcode.medium.Solution92}
 */
public class Solution206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = listNode;
        next = (next.next = new ListNode(2));
        next = (next.next = new ListNode(3));
        next = (next.next = new ListNode(4));
        next.next = new ListNode(5);
        new Solution206().reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        head = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = head;
            head = temp;
            temp = next;

        }
        return head;
    }
}
