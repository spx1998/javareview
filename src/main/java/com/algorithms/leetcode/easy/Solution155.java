package com.algorithms.leetcode.easy;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 解法1：
 * 暴力解法；
 * 辅助栈解法：
 * 典型做法：用两个栈，stack1存插入的实际数据，stack2存min值，插入一个元素时，向stack1中push当前元素x，向stack2中push最小值（如果x小于stack.peek()
 * 则是x，否则是stack.peek()）。取出一个元素时，stack1和stack2都执行pop操作。
 * 用一个集合的做法：双向队列，向双向延展，一半相当于stack1，一半相等于stack2.
 */
public class Solution155 {
    public static void main(String[] args) {
        MinStack0 minStack = new Solution155().new MinStack0();
        minStack.push(1);
        minStack.push(1);
        minStack.push(2);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2);
        minStack.top();
        minStack.getMin();
        System.out.println();
    }

    class MinStack0 {

        Stack<Integer> stack;
        LinkedList<Integer> linkedList;

        /**
         * initialize your data structure here.
         */
        public MinStack0() {
            stack = new Stack<>();
            linkedList = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (linkedList.size() == 0) {
                linkedList.add(x);
                return;
            }
            for (int i = 0; i < linkedList.size(); i++) {
                if (x <= linkedList.get(i)) {
                    linkedList.add(i, x);
                    return;
                }
            }
            linkedList.add(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(pop)) {
                    iterator.remove();
                    break;
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return linkedList.getFirst();
        }
    }

    /**
     * 辅助栈
     */
    class MinStack {
        Deque<Integer> deque;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            deque = new LinkedList<>();
        }

        public void push(int x) {
            if (deque.isEmpty()) {
                deque.addFirst(x);
            } else {
                if (deque.getFirst() > x) {
                    deque.addFirst(x);
                } else {
                    deque.addFirst(deque.getFirst());
                }
            }
            deque.addLast(x);
        }

        public void pop() {
            deque.removeFirst();
            deque.removeLast();
        }

        public int top() {
            return deque.getLast();
        }

        public int getMin() {
            return deque.getFirst();
        }
    }
}
