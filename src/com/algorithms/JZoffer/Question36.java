package com.algorithms.JZoffer;

import com.algorithms.datastructure.ListNode;

import java.util.LinkedHashMap;

public class Question36 {
    public static void main(String[] args) {
        Question36 question36 = new Question36();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(7);
        ListNode l2 =new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = l1.next.next.next;
        question36.FindFirstCommonNode(l1,l2);
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        LinkedHashMap<ListNode,Integer> linkedHashMap = new LinkedHashMap<>();
        while (pHead1!=null){
            linkedHashMap.put(pHead1,1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if(linkedHashMap.get(pHead2)!=null){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}