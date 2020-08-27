package com.algorithms.datastructure;

public class TreeNode {
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(int x){
        val = x;
    }
    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
