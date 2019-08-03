package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

public class Question18 {
    public static void main(String[] args) {
        Question18 question18 = new Question18();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        question18.Mirror(root);
    }


    public void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode mid =root.left;
            root.left = root.right;
            root.right = mid;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

}