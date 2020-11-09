package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.Node;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * 示例：
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 解法1：
 * 层序遍历，空间复杂度O(logn)
 * 解法2：
 * 递归，空间复杂度O(1)
 * 1）对于每个节点，若有子树，则先将左右子树相连，若子树还有子树，则将左侧最右节点的next指向右侧最左节点，直到到达叶子节点。
 * 2）按层链接，当第n层链接后，第n+1层可以根据第n层的链接链接。
 */
public class Solution116 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        new Solution116().connect(node);
    }

    public Node connect(Node root) {
        doConnect(root);
        return root;
    }

    private void doConnect(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.left.left != null) {
                doConnect(root.left);
                doConnect(root.right);
                Node temp1 = root.left;
                Node temp2 = root.right;
                while (temp1.right != null) {
                    temp1.right.next = temp2.left;
                    temp1 = temp1.right;
                    temp2 = temp2.left;
                }

            }
        }
    }

    /**
     * 递归2
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp.left != null) {
            Node head = temp;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            temp = temp.left;
        }
        return root;
    }
}
