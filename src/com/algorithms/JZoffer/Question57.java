package com.algorithms.JZoffer;

import com.algorithms.datastructure.TreeLinkNode;

public class Question57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }else {
            if(pNode.next==null)return null;
            while (pNode.next!=null){
                if(pNode==pNode.next.left)
                    return pNode.next;
                else
                    pNode=pNode.next;
            }
            return null;
        }
    }
}