package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 我的解法：
 * 使用了格外的数组空间，来简化来链表翻转的操作。但时间复杂度与直接翻转链表相同都是O(n)，而空间复杂度为O(k),是在编码上讨巧的做法。
 *
 * 其他解法：
 * 使用链表翻转的做法处理链表翻转，空间复杂度为O(1)。
 *
 * 相关问题：
 * leetcode24题 {@link com.algorithms.leetcode.medium.Solution24}
 */
public class Solution25 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new Solution25().reverseKGroup(listNode, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (count(cur, k)) {
            cur = reverse(cur, k);
        }
        return pre.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            listNodes[i] = cur.next;
            cur = cur.next;
        }
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                listNodes[i].next = listNodes[k - 1].next;
            } else {
                listNodes[i].next = listNodes[i - 1];
            }
        }
        head.next = listNodes[k - 1];
        return listNodes[0];
    }

    private boolean count(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur.next == null) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}

