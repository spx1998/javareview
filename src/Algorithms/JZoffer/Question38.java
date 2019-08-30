package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

public class Question38 {
    public static void main(String[] args) {
        Question38 question38 =new Question38();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(question38.TreeDepth(root));
    }
    public int TreeDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)
            return 1;
        else {
            int ld = 1+depth(root.left);
            int rd = 1+depth(root.right);
            return Math.max(ld,rd);
        }
    }
}