package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

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
 * *    /  \
 * *  15   7
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return buildTree(preorder, inorder, 0, 0, length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pAddr, int iStart, int iEnd) {

        int iAddr = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == preorder[pAddr]) {
                iAddr = i;
                break;

            }
        }
        TreeNode root = new TreeNode(preorder[pAddr]);
        root.left = buildTree(preorder, inorder, pAddr + 1, iStart, iAddr);
//        root.right = buildTree();
        return root;
    }
}
