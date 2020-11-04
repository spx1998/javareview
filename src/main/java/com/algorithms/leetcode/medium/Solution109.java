package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.ListNode;
import com.algorithms.datastructure.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * *        0
 * *       / \
 * *     -3   9
 * *    /   /
 * * -10  5
 * <p>
 * 解法：
 * 类似108题，但对于链表应该用快慢指针去确定中间值。
 *
 * 相关问题：
 * leetcode 108题 {@link com.algorithms.leetcode.easy.Solution108}
 */
public class Solution109 {
    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);
        new Solution109().sortedListToBST(node);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

}
