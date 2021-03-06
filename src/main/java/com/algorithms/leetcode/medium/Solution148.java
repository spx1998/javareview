package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目在范围[0, 5 * 104]内
 * -105<= Node.val <= 105
 * 解法：
 * 时间复杂度为O(nlogn)的排序算法中，归并排序更适用于链表。
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = head;
        ListNode doubleMid = head;
        while (doubleMid != tail) {
            mid = mid.next;
            doubleMid = doubleMid.next;
            if (doubleMid != tail) {
                doubleMid = doubleMid.next;
            }
        }
        ListNode head1 = sortList(head, mid);
        ListNode head2 = sortList(mid, tail);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
