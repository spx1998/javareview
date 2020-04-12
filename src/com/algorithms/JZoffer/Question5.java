package com.algorithms.JZoffer;

import java.util.Stack;

public class Question5 {
    public static void main(String[] args) {
        Question5 question5 =new Question5();
        question5.pop();
        question5.push(1);
        question5.push(2);
        question5.push(3);
        question5.push(4);
        System.out.println(question5.pop());
        question5.push(7);
        System.out.println(question5.pop());
        System.out.println(question5.pop());
    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if(stack1.empty())
            return  0;
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
