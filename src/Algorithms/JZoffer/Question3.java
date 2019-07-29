package Algorithms.JZoffer;

import Algorithms.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        Question3 question3 =new Question3();
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(9);
        System.out.println(Arrays.toString(question3.printListFromTailToHead(head).toArray()));
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack =new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            arrayList.add(stack.pop());
        }
        return  arrayList;
    }
}
