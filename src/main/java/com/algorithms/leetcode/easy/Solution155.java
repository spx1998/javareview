package com.algorithms.leetcode.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class Solution155 {
    public static void main(String[] args) {
        MinStack minStack = new Solution155().new MinStack();
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
    class MinStack {

        Stack<Integer> stack;
        LinkedList<Integer> linkedList;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            linkedList = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if(linkedList.size()==0){
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
}
