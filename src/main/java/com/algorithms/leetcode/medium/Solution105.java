package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * *     3
 * *    / \
 * *   9  20
 * *     /  \
 * *    15   7
 * 我的解法：
 * 递归的方法，区间内，前序遍历的第一个值为根节点，其后的元素根据中序遍历中的第一个值的位置划分为左右两个区间，分别构成根节点的两颗子树。
 * 区间最初为[0,length-1]，之后每次更新类似二分查找。
 * 优化：可以用map存储中序遍历中每个值对应的位置
 * key   -> inorder[i]
 * value -> i
 * <p>
 * 迭代解法：
 * 需要观察得知，
 * 1）在前序遍历中相邻的两个节点a b，要么b是a的左子树的根节点，要么a没有左子树，b是a或a的某个父节点的右子树。
 * 2）对于一棵树，如果没有左子树，根节点的前序遍历和中序遍历位置相同；换言之，如果位置不同，则一定有左子树。
 * 相关问题：
 * leetcode 第106题 {@link Solution106}
 */
public class Solution105 {
    public static void main(String[] args) {
        int[] ints1 = new int[]{3, 9, 20, 15, 7};
        int[] ints2 = {9, 3, 15, 20, 7};
        new Solution105().buildTree(ints1, ints2);
    }

    /**
     * 递归
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return buildTree(preorder, inorder, 0, 0, length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pAddr, int iStart, int iEnd) {
        if (iEnd < iStart) {
            return null;
        }
        int iAddr = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == preorder[pAddr]) {
                iAddr = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[pAddr]);
        root.left = buildTree(preorder, inorder, pAddr + 1, iStart, iAddr - 1);
        root.right = buildTree(preorder, inorder, pAddr + iAddr - iStart + 1, iAddr + 1, iEnd);
        return root;
    }

    /**
     * 迭代
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
//            node.val==inorder[inorderIndex] 说明node无左子树或左子树已经遍历完成
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;

    }
}
