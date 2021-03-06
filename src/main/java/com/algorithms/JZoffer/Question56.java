package com.algorithms.JZoffer;

import com.algorithms.datastructure.ListNode;

public class Question56 {
    public static void main(String[] args) {
        Question56 question56 =new Question56();
        ListNode head =new ListNode(1);
        head.next= new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next =new ListNode(5);
        ListNode newHead = question56.deleteDuplication(head);
        System.out.println(" ");
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null) return pHead;
        ListNode head = pHead;
        ListNode tempNode = pHead;
        int temp = pHead.val;
        pHead=pHead.next;
        while (pHead!=null){
            if(pHead.val==temp){
                if(pHead.next!=null&&pHead.next.val==temp){
                    pHead=pHead.next;
                }else if(temp==head.val){
                    tempNode=pHead.next;
                    head=pHead.next;
                    pHead= pHead.next;
                }else {
                    tempNode.next=pHead.next;
                    pHead=pHead.next;
                }
            }else {
                if(pHead.next==null||pHead.next.val!=pHead.val)
                    tempNode=pHead;
                temp=pHead.val;
                pHead=pHead.next;
            }
        }
        return head;
    }
}
