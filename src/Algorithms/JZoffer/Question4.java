package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;
import Algorithms.tree.Traverse;

public class Question4 {
    public static void main(String[] args) {
        Question4 question4 =new Question4();
        int[] pre ={1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = question4.reConstructBinaryTree(pre,in);
        Traverse traverse =new Traverse();
        traverse.traverse(root);
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int p1, int p2, int i1, int i2) {
        if(p1>p2||i1>i2){
            return null;
        }
        TreeNode root = new TreeNode(pre[p1]);
        for(int i=0;i<in.length;i++){
            if(root.val==in[i]){
                root.left = reConstructBinaryTree(pre,in,p1+1,p1+i-i1,i1,i-1);
                root.right = reConstructBinaryTree(pre,in,p1+i-i1+1,p2,i+1,i2);
            }
        }
        return root;
    }
}
