package com.algorithms.leetcode.hot100;

import com.algorithms.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        while (listNodes.size() != 1) {
            ListNode l1 = listNodes.remove(0);
            ListNode l2 = listNodes.remove(0);
            listNodes.add(mergeTwoLists(l1, l2));
        }
        return listNodes.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return sentinel.next;
    }
}
