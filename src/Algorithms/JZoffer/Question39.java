package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

public class Question39 {
    private boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        flag = true;
        judge(root);
        return flag;
    }
    private  int judge(TreeNode root){
        if(root==null)return 0;
        else {
            int ld = 1+judge(root.left);
            int rd = 1+judge(root.right);
            if(ld-rd>=2||ld-rd<=-2)
                flag=false;
//            if(root.right!=null&&root.right.val<root.val)
//                flag =false;
//            if (root.left!=null&&root.left.val>root.val)
//                flag = false;
            return Math.max(ld,rd);
        }
    }
}