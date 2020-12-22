package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.randomlistnode.Node;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * 我们用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * 我的解法：
 * 用原有node作key，clone的node作value构造一个HashMap。遍历链表，如果random和next的节点已经有clone的节点，则新链表指向它，否则创建一个clone节点，加入map中。
 * 相关问题
 * leetcode 第133题 {@link Solution133}
 */
public class Solution138 {
    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.random = node;
        new Solution138().copyRandomList(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node res = new Node(head.val);
        map.put(head, res);
        Node cur = res;
        while (head != null) {
            Node node;
            if (head.next != null) {
                if (map.get(head.next) != null) {
                    node = map.get(head.next);
                } else {
                    node = new Node(head.next.val);
                    map.put(head.next, node);
                }
                cur.next = node;
            }
            if (head.random != null) {
                if (map.get(head.random) != null) {
                    cur.random = map.get(head.random);
                } else {
                    cur.random = new Node(head.random.val);
                    map.put(head.random, cur.random);
                }
            }
            cur = cur.next;
            head = head.next;
        }
        return res;
    }
}
