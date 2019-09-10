package Algorithms.JZoffer;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Question24$$$ {
    public static void main(String[] args) {
        Question24$$$ question24$$$ = new Question24$$$();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>>arrayLists = question24$$$.FindPath(root,6);

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
