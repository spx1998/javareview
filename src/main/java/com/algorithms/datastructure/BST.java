package com.algorithms.datastructure;

public class BST {
    TreeNode root;

    public void put(int num) {
        TreeNode newNode = new TreeNode(num);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode treeNode = root;
        TreeNode parent = null;
        while (treeNode != null) {
            parent = treeNode;
            if (treeNode.val < num) {
                treeNode = treeNode.right;
            } else {
                treeNode = treeNode.left;
            }
        }
        if (parent.val > num) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }


    public int get(int num) {
        TreeNode treeNode = root;
        while (treeNode != null) {
            if (treeNode.val == num) {
                return num;
            } else if (treeNode.val < num) {
                treeNode = treeNode.right;
            } else {
                treeNode = treeNode.left;
            }
        }
        return -1;
    }

    //    假设无重复元素
    public void delete(int num) {
        TreeNode parent = getNodeParent(num);
        if (parent != null && parent.val == -1) {
            return;
        }
        TreeNode node;
        if (parent == null) {
            node = root;
        } else if (parent.val > num) {
            node = parent.left;
        } else {
            node = parent.right;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        TreeNode newNode = getNewNode(right);

        if (newNode == null) {
            return;
        } else if (parent != null) {
            if (parent.val > num) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
        newNode.left = left;
        if (newNode != right) {
            newNode.right = right;
        }
    }


    private TreeNode getNewNode(TreeNode right) {
        TreeNode parent = null;
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            parent = right;
            right = right.left;
        }
        if (right.right != null) {
            if (parent != null) {
                parent.left = right.right;
            }
        }
        return right;
    }

    public TreeNode getNodeParent(int num) {
        TreeNode parent = null;
        TreeNode treeNode = root;
        while (treeNode != null) {
            if (treeNode.val == num) {
                return parent;
            } else if (treeNode.val < num) {
                treeNode = treeNode.right;
            } else {
                treeNode = treeNode.left;
            }
            parent = treeNode;
        }
        return new TreeNode(-1);
    }


}
