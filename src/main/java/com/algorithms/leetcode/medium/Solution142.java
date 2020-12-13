package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * 解法：
 * 快慢指针，设没有在环内的距离为x，快慢指针相遇时慢指针走的环内距离为a，环内剩余距离为b。
 * 则  2 * ( x + a ) = x + n * (a + b ) + a
 * 整理得 x = n * ( a + b ) - a
 * 由于 此时两个指针的位置都在a处，则将一个指针fast移回起点，另一个指针slow不同，两者以同样速度移动，
 * 当fast移动x次到达入环处时，slow在环中的位置为 (a + x ) % ( a + b ),即( n*( a + b ) ) % ( a + b ), 即入环处。
 * 两指针将在入环处第二次相遇。
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}
