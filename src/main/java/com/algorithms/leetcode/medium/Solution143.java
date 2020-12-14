package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 我的解法：
 * 用map存链表中的每一个值，再组装成新的链表。空间复杂度O(n)
 * 优化：
 * map->array
 * 其他解法：
 * 双指针找到链表中间点，将右半部分翻转，再将前后两个链表合并。
 *
 */
public class Solution143 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new Solution143().reorderList(listNode);
    }

    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int num = 1;
        while (head != null) {
            map.put(num, head);
            num++;
            head = head.next;
        }
        for (int i = 1; i <= num / 2; i++) {
            ListNode next = map.get(i).next;
            if (i == num - i) {
                map.get(i).next = null;
            }
            map.get(i).next = map.get(num - i);
            if (i + 1 > num / 2) {
                map.get(i).next.next = null;
                continue;
            }
            map.get(i).next.next = next;
        }
    }
}
