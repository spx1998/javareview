package com.algorithms.JZoffer;

import com.algorithms.datastructure.ListNode;

public class Question16 {
    public static void main(String[] args) {
        Question16 question16 = new Question16();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next =new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(7);
        question16.Merge(l1,l2);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if (list2==null) return list1;
        ListNode head = list1.val<=list2.val?list1:list2;
        if(head==list1){
            list1 = list1.next;
        }else {
            list2=list2.next;
        }
        head.next=null;
        ListNode tail =head;
        ListNode temp;
        while (list1!=null){
            while (list2!=null){
                if(list1.val>list2.val){
                    temp = list2;
                    list2 = list2.next;
                    temp.next =null;
                    tail.next = temp;
                    tail = tail.next;
                }else break;
            }
            temp = list1;
            list1 = list1.next;
            temp.next=null;
            tail.next = temp;
            tail = tail.next;
        }
        if(list2!=null){
            tail.next = list2;
        }
        return head;
    }
}