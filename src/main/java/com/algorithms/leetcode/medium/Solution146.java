package com.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，
 * 则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 10^4 次 get 和 put
 * <p>
 * 解法1：
 * 用一个map存值，一个queue记录使用情况，最近put或get的key从queue中移到队尾。
 * 解法2：
 * O(1)的解法。
 * 构建一个新的数据结构Node，保存存入的每个key，value以及当前节点的preNode和nextNode。用一个hashMap存key和对应的Node。同时用两个指针head和tail存储node链表的头尾节点。
 * 在每次put和get操作时候，变更node链表的顺序并维护head和tail指针指向正确的节点。在put时，如果lru容器已满则删除tail指向的node。
 */
public class Solution146 {
    class LRUCache0 {
        Map<Integer, Integer> map;
        Queue<Integer> queue = new LinkedList<>();
        int capacity;

        public LRUCache0(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer res = map.get(key);
            if (res == null) {
                return -1;
            }
            queue.remove(key);
            queue.offer(key);
            return res;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                queue.remove(key);
            } else if (capacity == map.size()) {
                Integer remove = queue.remove();
                map.remove(remove);
            }
            queue.offer(key);
            map.put(key, value);
        }
    }

    /**
     * O(1)的解法
     */
    public static void main(String[] args) {
        LRUCache lruCache = new Solution146().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }

    class LRUCache {
        class Node {
            int key;
            int value;
            Node pre;
            Node next;
        }

        int capacity;


        Map<Integer, Node> map;
        Node head;
        Node tail;


        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                if (head != node) {
                    if (node != tail) {
                        node.pre.next = node.next;
                        node.next.pre = node.pre;
                    } else {
                        node.pre.next = null;
                        tail = node.pre;
                    }
                    head.pre = node;
                    node.pre = null;
                    node.next = head;
                    head = node;
                }
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                if (head != node) {
                    if (node != tail) {
                        node.pre.next = node.next;
                        node.next.pre = node.pre;
                    } else {
                        node.pre.next = null;
                        tail = node.pre;
                    }
                    head.pre = node;
                    node.pre = null;
                    node.next = head;
                    head = node;
                }
            } else {
                if (map.size() == capacity) {
                    map.remove(tail.key);
                    if (tail.pre != null) {
                        tail = tail.pre;
                        tail.next = null;
                    } else {
                        tail = null;
                    }
                }
                Node node = new Node();
                node.key = key;
                node.value = value;
                if (head != null) {
                    node.next = head;
                    head.pre = node;
                }
                head = node;
                if (tail == null) {
                    tail = node;
                }
                map.put(key, node);
            }
        }
    }
}
