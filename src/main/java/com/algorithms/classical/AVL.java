package com.algorithms.classical;

/**
 * 自平衡二叉查找树
 * 平衡因子的绝对值<=1的二叉查找树
 * 遍历操作如BST
 * 四种插入节点的case通过旋转进行自平衡
 * 四种删除节点的操作，可以看作插入操作处理。
 */
public class AVL {

    TreeNode root;

    /**
     * 树节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int depth;

        public TreeNode(int val, TreeNode parent) {

        }
    }


    /**
     * 左旋
     * 四个旋转操作的入参都是旋转前的“根节点”
     */
    private void leftSpin(TreeNode treeNode) {
        TreeNode parent = treeNode.parent;
        TreeNode right = treeNode.right;
        treeNode.right = right.left;
        right.left = treeNode;
        if (parent != null) {
            if (parent.right == treeNode) {
                parent.right = right;
            } else {
                parent.left = right;
            }
        }
    }

    /**
     * 右旋
     */
    private void rightSpin(TreeNode treeNode) {
        TreeNode parent = treeNode.parent;
        TreeNode left = treeNode.left;
        treeNode.left = left.right;
        left.right = treeNode;
        if (parent != null) {
            if (parent.right == treeNode) {
                parent.right = left;
            } else {
                parent.left = left;
            }
        }
    }

    /**
     * 先左再右
     */
    private void leftRightSpin(TreeNode treeNode) {
        leftSpin(treeNode.left);
        rightSpin(treeNode);
    }

    /**
     * 先右再左
     */
    private void rightLeftSpin(TreeNode treeNode) {
        rightSpin(treeNode.right);
        leftSpin(treeNode);
    }

    /**
     * 添加节点 找到最小失衡树，判断属于四种case中的哪一种。
     */
    public void insert(int n) {
        doInsert(n, root, null);
    }


    private void doInsert(int val, TreeNode root, TreeNode parent) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val, parent);
            if (this.root == null) {
                this.root = treeNode;
                return;
            }
        } else {

        }

    }

    /**
     * 删除节点
     */
    public void remove(int n) {

    }

}
