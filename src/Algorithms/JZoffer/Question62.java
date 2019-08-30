package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.Stack;

public class Question62 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left= new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        Question62 question62 = new Question62();
        question62.KthNode(root,3);
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        if(pRoot==null)return null;
        while (pRoot!=null||!stack.empty()){
            while (pRoot!=null){
                stack.push(pRoot);
                pRoot=pRoot.left;
            }
            if (!stack.empty()){
                pRoot=stack.pop();
                k--;
                if(k==0)return pRoot;
                pRoot=pRoot.right;
            }
        }
        return null;
    }

}
