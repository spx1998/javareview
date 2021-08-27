package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 题解：代码中
 */
public class Solution863 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(3);
        new Solution863().distanceK(treeNode, treeNode.right.left, 3);
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
//        后序遍历，找到target在root中的位置，且此时stack中的内容是root到target的路径。
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
//                达到target节点，开始寻找结果集合。
                if (root == target) {
                    Boolean isLeft = null;
//                    首先是target的子节点
                    getResult((pre = stack.pop()), k--, isLeft, res);
//                    target的祖先节点的另一子树中的结果。要判断target在这个祖先节点的左侧还是右侧，从而得知另一子树在左侧还是右侧。
                    while (!stack.isEmpty() && k >= 0) {
                        if (pre == stack.peek().left) {
                            isLeft = true;
                        }
                        if (pre == stack.peek().right) {
                            isLeft = false;
                        }
//                        得知后去子树找寻结果
                        getResult((pre = stack.pop()), k--, isLeft, res);
                    }
                    return res;
                }
                root = root.left;
            }
//            后序遍历判断是第几次遍历stack中的元素的判断条件
            if (pre == stack.peek().right || stack.peek().right == null) {
                pre = stack.pop();
            } else {
                root = stack.peek().right;
            }
        }
        return res;
    }

    private void getResult(TreeNode root, int k, Boolean isLeft, List<Integer> list) {
        if (k == 0) {
            list.add(root.val);
            return;
        }
        if (isLeft == null) {
            doGetResult(root, k, list);
            return;
        }
        if (isLeft) {
            doGetResult(root.right, k - 1, list);
        } else {
            doGetResult(root.left, k - 1, list);
        }
    }

//    层序遍历，找寻结果
    private void doGetResult(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            list.add(root.val);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            k--;
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
    }
}
