package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot==null)return arrayLists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count=1;
        ArrayList<Integer> arrayList =new ArrayList<>();
        TreeNode thisNode;
        while (!queue.isEmpty()){
            thisNode=queue.poll();
            arrayList.add(thisNode.val);
            count--;
            if(thisNode.left!=null){
                queue.offer(thisNode.left);
            }
            if(thisNode.right!=null){
                queue.offer(thisNode.right);
            }
            if(count==0){
                count=queue.size();
                arrayLists.add(arrayList);
                arrayList = new ArrayList<>();
            }
        }
        return arrayLists;
    }
}
