package Algorithms.JZoffer;

import Algorithms.datastructure.ListNode;

public class Question14 {
    public static void main(String[] args) {
        Question14 question14 = new Question14();
        ListNode head = new ListNode(1);
        question14.FindKthToTail(head,3);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head==null||k<=0) return null;
        ListNode temp = head;
        for(int i=1;i<k;i++){
            temp = temp.next;
            if(temp==null)
                return null;
        }
        while (temp.next!=null){
            temp = temp.next;
            head = head.next;
        }
        return head;
    }
}
