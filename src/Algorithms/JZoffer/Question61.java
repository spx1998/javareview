package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Question61 {
    public static void main(String[] args) {
        Question61 question61 = new Question61();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left =new TreeNode(2);
        String str;
        System.out.println((str=question61.Serialize(root)));
        question61.Deserialize(str);
    }
    String Serialize(TreeNode root) {
        if(root==null) return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (root!=null||!queue.isEmpty()){
            root=queue.poll();
            if(root==null){
                sb.append("#");
            }else {
                queue.offer(root.left);
                queue.offer(root.right);
                sb.append(root.val).append("!");
            }
        }
        int i=sb.lastIndexOf("!");
        sb.delete(i+1,sb.length());
        return String.valueOf(sb);
    }
    TreeNode Deserialize(String str) {
        if(str.startsWith("#"))return null;
        boolean flag=true;
        String[]strs = str.split("!");
        Queue<TreeNode> treeNodes = new LinkedList<>();
        TreeNode root;
        treeNodes.offer((root=new TreeNode(Integer.parseInt(strs[0]))));
        TreeNode node=root;
        int i=1;
        while (i<strs.length){
            if(flag)
                node=treeNodes.poll();
            if(strs[i].startsWith("#")){
                int k=0;
                while (strs[i].startsWith("#")){
                    strs[i]=strs[i].substring(1);
                    k++;
                }
                while (k!=0){
                    if(flag){
                        node.left=null;
                        flag=!flag;
                        k--;
                    }else {
                        node.right=null;
                        flag=!flag;
                        node=treeNodes.poll();
                        k--;
                    }
                }
                if(flag) {
                    node.left=new TreeNode(Integer.parseInt(strs[i]));
                    treeNodes.offer(node.left);
                    flag=!flag;
                }else {
                    (node).right=new TreeNode(Integer.parseInt(strs[i]));
                    treeNodes.offer(node.right);
                    flag=!flag;
                }
            }else {
                if(flag){
                    node.left=new TreeNode(Integer.parseInt(strs[i]));
                    flag=!flag;
                    treeNodes.offer(node.left);

                }else {
                    node.right=new TreeNode(Integer.parseInt(strs[i]));
                    flag=!flag;
                    treeNodes.offer(node.right);

                }
            }
            i++;
        }

        return root;
    }
}
