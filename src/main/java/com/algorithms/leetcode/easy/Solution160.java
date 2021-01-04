package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 解法：
 * 比较两个链表长度，将较长的链表提前后移使链表长度相同，再遍历即可。
 */
public class Solution160 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(10);
        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = listNode.next.next;
        new Solution160().getIntersectionNode(listNode,listNode1);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int numA = 0;
        int numB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            numA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            numB++;
        }
        if (numA > numB) {
            int i = numA - numB;
            while (i > 0) {
                headA = headA.next;
                i--;
            }
        } else if (numA < numB) {
            int i = numB - numA;
            while (i > 0) {
                headB = headB.next;
                i--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
