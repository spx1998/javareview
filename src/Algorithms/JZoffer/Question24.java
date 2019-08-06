package Algorithms.JZoffer;

import Algorithms.datastructure.RandomListNode;

public class Question24 {
    public static void main(String[] args) {
        Question24 question24 = new Question24();
        RandomListNode head = new RandomListNode(1);
        question24.Clone(head);
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode oldTemp = pHead.next;
        RandomListNode newTemp = newHead;
        while (oldTemp!=null){
            newTemp.next = new RandomListNode(oldTemp.label);
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }
        oldTemp = pHead;
        newTemp = newHead;
        while (oldTemp!=null){
            if (oldTemp.random==null){
                newTemp = newTemp.next;
                oldTemp = oldTemp.next;
                continue;
            }
            RandomListNode randomListNode = newHead;
            while (randomListNode!=null){
                if(randomListNode.label == oldTemp.random.label){
                    break;
                }
                randomListNode = randomListNode.next;
            }
            newTemp.random = randomListNode;
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }
        return newHead;
    }
}





