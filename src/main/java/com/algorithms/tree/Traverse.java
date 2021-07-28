package com.algorithms.tree;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * @author 45779
 * xxx1为递归方法，xxx2为非递归方法
 * 实验使用的树：
 * *     1
 * *   2   3
 * * 4  5 6  7
 */
public class Traverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
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
        System.out.println("\n非递归后序遍历2：");
        test.postTraverse3(root);
        System.out.println("\n层序遍历：");
        test.traverse(root);
    }

    //前序递归
    public void preTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preTraverse1(root.left);
            preTraverse1(root.right);
        }
    }

    //前序非递归
    public void preTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop().right;
            }
        }
    }

    //中序递归
    public void inTraverse1(TreeNode root) {
        if (root != null) {
            inTraverse1(root.left);
            System.out.print(root.val + " ");
            inTraverse1(root.right);
        }
    }

    //中序非递归
    public void inTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                System.out.print(stack.peek().val + " ");
                root = stack.pop().right;
            }
        }
    }

    //后序递归
    public void postTraverse1(TreeNode root) {
        if (root != null) {
            postTraverse1(root.left);
            postTraverse1(root.right);
            System.out.print(root.val + " ");
        }
    }

    //后序非递归方法1：看作先右后左的先序遍历的倒序。
    //1376254->4526731
    public void postTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                integerStack.push(root.val);
                stack.push(root);
                root = root.right;
            }
            if (!stack.empty()) {
                root = stack.pop().left;
            }
        }
        while (!integerStack.empty()) {
            System.out.print(integerStack.pop() + " ");
        }
    }

    /**
     * 第二种迭代后续遍历
     * 用一个cur记录当期节点的左右子节点是否已遍历。
     */
    public void postTraverse3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        TreeNode peek;
        TreeNode cur = root;
        while (!stack.empty()) {
            peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
            }
        }
    }

    /**
     * 实际的栈代替递归栈
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postTraverse4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode prev = root;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || prev == root.right) {
                stack.pop();
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }

        return result;
    }

    //层序遍历
    public void traverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        int i = 0;
        if (root != null) {
            list.add(root);
        }
        while (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
            i++;
            if (i < list.size()) {
                root = list.get(i);
            } else {
                break;
            }
        }
    }
}
