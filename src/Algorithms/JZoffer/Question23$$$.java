package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;

public class Question23$$$ {
    public static void main(String[] args) {
        Question23$$$ question23$$$ = new Question23$$$();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>>arrayLists = question23$$$.FindPath(root,6);

    }
    private    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root,target,new ArrayList<>());
        return  arrayLists;
    }
    private void backtracking(TreeNode treeNode, int target,ArrayList<Integer>path){
        if(treeNode==null) return;
        path.add(treeNode.val);
        target -= treeNode.val;
        if(target==0&&treeNode.left==null&& treeNode.right==null){
            arrayLists.add(new ArrayList<>(path));
        }
        else {
            backtracking(treeNode.left,target,path);
            backtracking(treeNode.right,target,path);
        }
        path.remove(path.size()-1);
    }
}
