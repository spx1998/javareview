package com.algorithms.leetcode.medium;

import com.algorithms.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 解法：
 * 递归后序遍历树，如果当前节点为p或q，则记录到当前节点的路径，即各个父节点。最后比较得到p，q节点的最后一个父节点。
 * 优化写法：
 * 如解法2
 */
public class Solution236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        new Solution236().lowestCommonAncestor(root, root.left, root.right);
    }


    private final List<TreeNode> pList = new ArrayList<>();
    private final List<TreeNode> qList = new ArrayList<>();
    private final Stack<TreeNode> stack = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        for (int i = 0; i < pList.size(); i++) {
            if (i >= qList.size()) {
                return qList.get(qList.size() - 1);
            } else {
                if (pList.get(i) != qList.get(i)) {
                    return pList.get(i - 1);
                }
            }
        }
        return pList.get(pList.size() - 1);
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        stack.push(root);
        if (root == p) {
            pList.addAll(stack);
        }
        if (root == q) {
            qList.addAll(stack);
        }
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        stack.pop();
    }

    /**
     * 解法2：优化写法
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


}