package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *        4
 *      2   5
 *    1  3
 */
public class Question26 {
    public static void main(String[] args) {
        Question26 question26 = new Question26();
        TreeNode root =new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        TreeNode treeNode = question26.Convert(root);
        while (treeNode!=null){
            System.out.println(treeNode.toString());
            treeNode = treeNode.right;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (pRootOfTree!=null||!stack.empty()){
            while (pRootOfTree!=null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            if(!stack.empty()){
                arrayList.add(stack.peek());
                pRootOfTree = stack.pop().right;
            }
        }
        if(arrayList.size()==1){
            return arrayList.get(0);
        }
        for (int i=0;i<arrayList.size();i++){
            if(i==arrayList.size()-1){
                arrayList.get(i).right = null;
                arrayList.get(i).left = arrayList.get(i-1);
            }else if(i==0){
                arrayList.get(i).right = arrayList.get(i+1);
                arrayList.get(i).left = null;
            } else{
                arrayList.get(i).right = arrayList.get(i+1);
                arrayList.get(i).left = arrayList.get(i-1);
            }
        }
        return arrayList.get(0);
    }
}
