package com.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 * int get(int key)- 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value)- 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 * 我的解法：
 * hashMap+二维双向链表
 * 自定义了一个linkedList和一个node，linkedList用来存放count相同的node，且linkedList之间存在指针，指向count>curCount 或count<curCount 的最近的其他链表。node存放k，v 且含有一个指向所属linkedList的指针。
 * 比起直接用 {@link java.util.LinkedList} ,get 或 put 操作时 移除node的时间复杂度更低（O(1))。
 * HashMap 使得get复杂度为O(1).
 */
public class Solution460 {
    public static void main(String[] args) {
        LFUCache lfuCache = new Solution460().new LFUCache(1);
        lfuCache.put(2, 1);
        System.out.println(lfuCache.get(2));
        lfuCache.put(3, 2);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
    }

    public class LFUCache {
        Map<Integer, Node> map;
        int capacity;
        LinkedList tail;

        public class Node {
            public Node(int k, int v, LinkedList list) {
                this.key = k;
                this.value = v;
                enqueue(list);
            }
//            新节点入队
            private void enqueue(LinkedList list) {
                this.list = list;
                if (list.tail == null) {
                    list.tail = this;
                    list.head = this;
                } else {
                    Node temp = list.tail;
                    temp.next = this;
                    this.prev = temp;
                    list.tail = this;
                }
            }

            Node next;
            Node prev;
            LinkedList list;
            int value;
            int key;
        }

        public class LinkedList {
            Node tail;
            Node head;
            LinkedList prev;
            LinkedList next;
            int count;
        }

        public LFUCache(int capacity) {
            this.map = new HashMap<>(this.capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            move(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (map.get(key) != null) {
                map.get(key).value = value;
                move(map.get(key));
                return;
            }
            if (map.size() == capacity) {
                remove();
            }
            map.put(key, new Node(key, value, getListForNewNode()));
        }

        private void move(Node node) {
            LinkedList list = node.list;
//            从旧list移除
            if (list.head == node) {
                list.head = node.next;
            }
            if (list.tail == node) {
                list.tail = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
//            加入新list
            int count = list.count;
            LinkedList newList;
            if (list.prev == null) {
                newList = new LinkedList();
                newList.count = count + 1;
                node.enqueue(newList);
                newList.next = list;
                list.prev = newList;
                return;
            }
            if (list.prev.count > list.count + 1) {
                newList = new LinkedList();
                newList.count = count + 1;
                node.enqueue(newList);
                list.prev.next = newList;
                newList.prev = list.prev;
                newList.next = list;
                list.prev = newList;
                return;
            }
            newList = list.prev;
            node.enqueue(newList);
        }

        private LinkedList getListForNewNode() {
            if (tail == null) {
                LinkedList list = new LinkedList();
                list.count = 1;
                tail = list;
                return list;
            }
            if (tail.count != 1) {
                LinkedList list = new LinkedList();
                list.count = 1;
                tail.next = list;
                list.prev = tail;
                tail = list;
                return list;
            }
            return tail;
        }

        private void remove() {
//            清除无效的LinkedList
            while (tail != null && tail.head == null) {
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            }
            if (tail == null) {
                return;
            }
            map.remove(tail.head.key);
            tail.head = tail.head.next;
            if (tail.head == null) {
                tail.tail = null;
            } else {
                tail.head.prev.next = null;
                tail.head.prev = null;
            }
        }
    }
}
