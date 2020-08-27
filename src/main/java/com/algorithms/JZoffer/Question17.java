package com.algorithms.JZoffer;

import com.algorithms.datastructure.TreeNode;

import java.util.Stack;

public class Question17 {
    public static void main(String[] args) {
        Question17 question17 =new Question17();
        TreeNode root1 = new TreeNode(8);
        root1.right = new TreeNode(8);
        root1.right.right = new TreeNode(9);
        root1.right.right.right = new TreeNode(2);
        root1.right.right.right.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(8);
        root2.right = new TreeNode(9);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(2);
        System.out.println(question17.HasSubtree(root1,root2));
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        while (!stack.empty()){
            root1 = stack.pop();
            if(root1.val==root2.val){
                if(judge(root1,root2))return true;
            }
            if (root1.left !=null){
                stack.push(root1.left);
            }
            if(root1.right !=null){
                stack.push(root1.right);
            }

        }
        return false;
    }
    public boolean judge(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if(judge(root1.left,root2.left)&&judge(root1.right,root2.right)){
            return root1.val == root2.val;
        }
        return false;
    }
}