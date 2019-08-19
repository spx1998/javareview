package Algorithms.JZoffer;

import Algorithms.datastructure.ListNode;
import java.util.HashMap;
//还可以用快慢指针的方法
public class Question54 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        while (pHead!=null){
            hashMap.put(pHead,1);
            pHead=pHead.next;
            if(hashMap.get(pHead)!=null)
                return pHead;
        }
        return null;
    }
}
