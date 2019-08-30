package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question59 {
    public static void main(String[] args) {
        Question59 question59 =new Question59();
        TreeNode root =new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        while (true) {
            question59.Print(root);
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot==null)return arrayLists;
        int flag =1;
        int temp=0;
        int newflag=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> integers =new ArrayList<>();
        while (pRoot!=null||!queue.isEmpty()){
            pRoot=queue.poll();
            if(pRoot!=null) {
                queue.offer(pRoot.left);
                queue.offer(pRoot.right);
                newflag+=2;
                integers.add(pRoot.val);
            }
            temp++;
            if(temp==flag){
                temp=0;
                flag=newflag;
                newflag=0;
                if (integers.size()!=0)
                    arrayLists.add(integers);
                integers=new ArrayList<>();
            }
        }
        int sign=0;
        for (int i=0;i<arrayLists.size();i++){
            if(sign==0){
                sign=1;
            }else {
                sign=0;

                ArrayList<Integer> reverseList = new ArrayList<>();
                for(int j=arrayLists.get(i).size()-1;j>=0;j--){
                    reverseList.add(arrayLists.get(i).get(j));
                }
                arrayLists.set(i,reverseList);
            }
        }
        return arrayLists;

    }
}
