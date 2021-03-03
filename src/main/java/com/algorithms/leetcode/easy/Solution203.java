package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(val);
        ListNode cur = pre;
        pre.next = head;
        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
            } else {
                cur = cur.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}
