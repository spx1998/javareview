package com.algorithms.JZoffer;

import com.algorithms.datastructure.ListNode;

import java.util.Stack;

public class Question15 {
    public static void main(String[] args) {
        Question15 question15 = new Question15();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newHead = question15.ReverseList(head);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = null;
        while (head!=null){
            stack.push(head);
            temp =head.next;
            head.next = null;
            head = temp;
        }
        ListNode tail;
        ListNode newHead =null;
        if(!stack.empty()){
            tail = stack.pop();
            newHead = tail;
            while (!stack.empty()){
                tail.next=stack.pop();
                tail = tail.next;
            }
        }
        return newHead;
    }
}
