package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.Node;

/**
 * 给定一个二叉树
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 提示：
 * 树中的节点数小于 6000
 * -100<= node.val <= 100
 * <p>
 * 解法1：
 * 迭代中序遍历 空间复杂度O(n)
 * 解法2：
 * 迭代 如116题的第二种迭代解法
 *
 * 相似问题：
 * leetcode 116题 {@link Solution116}
 */
public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp != null) {
            Node childHead = null;
            Node childNext = null;
            Node tempNext = temp;
            while (tempNext != null) {
                if (childNext == null) {
                    if (tempNext.left != null) {
                        childHead = tempNext.left;
                        childNext = childHead;
                    }
                    if (tempNext.right != null) {
                        if (childHead == null) {
                            childHead = tempNext.right;
                            childNext = childHead;
                        } else {
                            childNext.next = tempNext.right;
                            childNext = childNext.next;
                        }
                    }
                } else {
                    if (tempNext.left != null) {
                        childNext.next = tempNext.left;
                        childNext = childNext.next;
                    }
                    if (tempNext.right != null) {
                        childNext.next = tempNext.right;
                        childNext = childNext.next;
                    }
                }
                tempNext = tempNext.next;
            }
            temp = childHead;
        }
        return root;
    }
}
