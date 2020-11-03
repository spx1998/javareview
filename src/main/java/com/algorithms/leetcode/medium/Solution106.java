package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * *     3
 * *    / \
 * *   9  20
 * *    /  \
 * *  15   7
 *
 * 解法：
 * 与105题类似
 *
 * 相关问题：
 * leetcode 第105题 {@link Solution105}
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return buildTree(postorder, inorder, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int pAddr, int iStart, int iEnd) {
        if (iEnd < iStart) {
            return null;
        }
        int iAddr = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == postorder[pAddr]) {
                iAddr = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[pAddr]);
        root.right = buildTree(postorder, inorder, pAddr - 1, iAddr + 1, iEnd);
        root.left = buildTree(postorder, inorder, pAddr - iEnd + iAddr - 1, iStart, iAddr - 1);
        return root;
    }
}
