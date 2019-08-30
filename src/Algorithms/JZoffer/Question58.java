package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question58 {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode lhead ;
        TreeNode rhead ;
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()){
            lhead=queue.poll();
            rhead=queue.poll();
            if(rhead==null&&lhead==null)continue;
            else if(rhead==null)return false;
            else if(lhead==null)return false;
            else if(lhead.val!=rhead.val)return false;
            else {
                queue.offer(lhead.left);
                queue.offer(rhead.right);
                queue.offer(lhead.right);
                queue.offer(rhead.left);
            }
        }
        return true;
    }
}
