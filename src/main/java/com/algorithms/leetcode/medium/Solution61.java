package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * 示例1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 * <p>
 * 我的解法：
 * 遍历一遍确定链表长度，然后找到length-(k%length)的位置，断开链表，将后一段移到前一段前。
 * <p>
 * 官方解法：
 * 在第一次遍历时同时将链表连成环，则可以省略断开链表后的一步。
 */
public class Solution61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = new Solution61().rotateRight(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode tail;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        tail = temp;
        k = k % length;
        if (k == 0) {
            return head;
        }
        temp = head;
        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;
        return newHead;
    }
}
