package com.algorithms.leetcode.easy;

import com.algorithms.datastructure.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * TODO
 */
public class Solution234 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        new Solution234().isPalindrome(node);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }

        ListNode h2 = slow.next;
        ListNode pre = null;
        while (h2 != null) {
            ListNode next = h2.next;
            h2.next = pre;
            pre = h2;
            h2 = next;
        }
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
