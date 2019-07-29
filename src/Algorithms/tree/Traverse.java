package Algorithms.tree;

import Algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 45779
 * xxx1为递归方法，xxx2为非递归方法
 * 实验使用的树：
 *      1
 *    2   3
 *  4  5 6  7
 */
public class Traverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);
        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild =new TreeNode(7);
        Traverse test = new Traverse();
        System.out.println("递归前序遍历：");
        test.preTraverse1(root);
        System.out.println("\n非递归前序遍历：");
        test.preTraverse2(root);
        System.out.println("\n递归中序遍历：");
        test.inTraverse1(root);
        System.out.println("\n非递归中序遍历：");
        test.inTraverse2(root);
        System.out.println("\n递归后序遍历：");
        test.postTraverse1(root);
        System.out.println("\n非递归后序遍历1：");
        test.postTraverse2(root);
        System.out.println("\n层序遍历：");
        test.traverse(root);
    }
    //前序递归
    public void preTraverse1(TreeNode root){
        if(root!=null) {
            System.out.print(root.val +" ");
            preTraverse1(root.leftChild);
            preTraverse1(root.rightChild);
        }
    }
    //前序非递归
    public void preTraverse2(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.leftChild;
            }
            if(!stack.empty()){
                root = stack.pop().rightChild;
            }
        }
    }
    //中序递归
    public void inTraverse1(TreeNode root){
        if (root!=null){
            inTraverse1(root.leftChild);
            System.out.print(root.val +" ");
            inTraverse1(root.rightChild);
        }
    }
    //中序非递归
    public void inTraverse2(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.leftChild;
            }
            if(!stack.empty()){
                System.out.print(stack.peek().val +" ");
                root = stack.pop().rightChild;
            }
        }
    }
    //后序递归
    public void postTraverse1(TreeNode root){
        if (root!=null){
            postTraverse1(root.leftChild);
            postTraverse1(root.rightChild);
            System.out.print(root.val +" ");
        }
    }
    //后序非递归方法1：看作先右后左的先序遍历的倒序。
    //1376254->4526731
    public void postTraverse2(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        Stack<Integer> integerStack =new Stack<>();
        while(root!=null||!stack.empty()){
            while (root!=null){
                integerStack.push(root.val);
                stack.push(root);
                root = root.rightChild;
            }
            if(!stack.empty()){
                root = stack.pop().leftChild;
            }
        }
        while (!integerStack.empty()){
            System.out.print(integerStack.pop()+" ");
        }
    }
    //层序遍历
    public void traverse(TreeNode root){
        List<TreeNode> list =new ArrayList<>();
        int i =0;
        if(root!=null)
            list.add(root);
        while (root!=null){
            System.out.print(root.val + " ");
            if(root.leftChild!=null)
                list.add(root.leftChild);
            if(root.rightChild!=null)
                list.add(root.rightChild);
            i++;
            if(i<list.size())
                root = list.get(i);
            else break;
        }
    }
}
