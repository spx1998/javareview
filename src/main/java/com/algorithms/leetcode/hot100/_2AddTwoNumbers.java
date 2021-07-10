package com.algorithms.leetcode.hot100;

import com.algorithms.datastructure.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int addOne = 0;
        ListNode node = l1;
        ListNode pre = l1;
        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val + addOne;
            l1.val = i % 10;
            addOne = i / 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp = null;
        if (l1 == null) {
            pre.next = l2;
            temp = l2;
        }
        if (l2 == null) {
            pre.next = l1;
            temp = l1;
        }
        while (temp != null && addOne != 0) {
            int i = temp.val + addOne;
            temp.val = i % 10;
            addOne = i / 10;
            pre = temp;
            temp = temp.next;
        }
        if(addOne!=0){
            pre.next = new ListNode(1);
        }
        return node;
    }
}
