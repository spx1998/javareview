package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 我的解法：
 * 比较数组中的每个链表的第一个节点，将最小的加入结果链表，然后将该节点的next放在数组的该位置。循环直至数组中所有元素都为null。
 * 优化：
 * 使用Priority Queue进行排序的过程。时间复杂度和编码难度都大大降低。（堆排序）
 * 其他解法：
 * 从将第1，2个链表合并，然后再将合成后的链表与第3个链表合并……直至最后一个链表。
 * 其他解法的优化：
 * 使用二分法优化链表合并的过程。
 */
public class Solution23 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[1] = new ListNode(1);
        listNodes[2] = new ListNode(2);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);
        listNodes[2].next = new ListNode(6);
        new Solution23().mergeKLists(listNodes);
    }

    /**
     * 暴力解法
     */
/*  public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        boolean bl = true;
        while (bl) {
            bl = false;
            ListNode temp = null;
            int tempNum = -1;
            int minNum = -1;
            for (int i = 0; i < lists.length; i++) {
                if (temp == null) {
                    if (lists[i] != null) {
                        bl = true;
                        tempNum = i;
                        minNum = i;
                        temp = lists[tempNum];
                    }
                } else {
                    if (lists[i] != null) {
                        bl = true;
                        if (temp.val > lists[i].val) {
                            temp = lists[i];
                            minNum = i;
                        }
                    }
                }
            }
            if (tempNum == -1) {
                return pre.next;
            }
            if (temp == lists[tempNum]) {
                lists[tempNum] = lists[tempNum].next;

            } else {
                lists[minNum] = lists[minNum].next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        return pre.next;
    }
*/

    /**
     * 优先队列（Priority Queue）
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        Queue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return pre.next;
    }
}
