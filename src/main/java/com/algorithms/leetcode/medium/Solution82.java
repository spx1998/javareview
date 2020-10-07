package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;
import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 我的解法：
 * 用一个pre指针指向head。遍历pre，如果当前节点的next节点是重复节点则向后去除重复节点；若不是，则将cur指向当前节点的next节点。遍历一次即可。
 */
public class Solution82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        new Solution82().deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        ListNode temp;
        pre.next = head;
        while (cur != null) {
            boolean bl = false;
            temp = cur.next;
            while (temp != null && temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
                bl = true;
            }
            if (bl) {
                temp = temp.next;
                cur.next = temp;
            } else {
                cur = temp;
            }
        }
        return pre.next;
    }
}
