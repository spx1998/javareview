package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question22 {
    public static void main(String[] args) {
        Question22 question22 = new Question22();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        question22.PrintFromTopToBottom(null);

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root==null)return arrayList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            arrayList.add(treeNode.val);
        }
        return arrayList;
    }
}
