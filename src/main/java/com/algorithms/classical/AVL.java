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
            this.val = val;
            this.parent = parent;
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
        right.left.parent = treeNode;
        right.left = treeNode;
        treeNode.parent = right;

        treeNode.depth = Math.max(getDepth(treeNode.left), getDepth(right.left)) + 1;
        right.depth = Math.max(getDepth(treeNode), getDepth(right.right)) + 1;

        setParent(right, parent);
    }

    /**
     * 右旋
     */
    private void rightSpin(TreeNode treeNode) {
        TreeNode parent = treeNode.parent;
        TreeNode left = treeNode.left;
        treeNode.left = left.right;
        left.right.parent = treeNode;
        left.right = treeNode;
        treeNode.parent = left;

        treeNode.depth = Math.max(getDepth(treeNode.right), getDepth(left.right)) + 1;
        left.depth = Math.max(getDepth(treeNode), getDepth(left.left)) + 1;
        setParent(left, parent);
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
     * 建立父子关系
     */
    private void setParent(TreeNode child, TreeNode parent) {
        if (parent != null) {
            if (child.val < parent.val) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    /**
     * 添加节点 找到最小失衡树，判断属于四种case中的哪一种。
     */
    public void insert(int n) {
        try {
            doInsert(n, root, null);
        } catch (Exception e) {
            System.out.println("duplicate val");
        }
    }


    /**
     * 实际插入操作，递归进行；如果检测到失衡，判断属于哪种case并旋转；最后计算深度。
     */
    private void doInsert(int val, TreeNode root, TreeNode parent) throws Exception {
        if (root == null) {
            root = new TreeNode(val, parent);
            if (this.root == null) {
                this.root = root;
            } else {
                if (parent.val > root.val) {
                    parent.left = root;
                } else {
                    parent.right = root;
                }
            }
        } else {
            if (val > root.val) {
                doInsert(val, root.right, root);
                if (getDepth(root.left) - getDepth(root.right) < -1) {
                    if (getDepth(root.right.right) > getDepth(root.right.left)) {
                        leftSpin(root);
                    } else {
                        rightLeftSpin(root);
                    }
                }
            } else if (val < root.val) {
                doInsert(val, root.left, root);
                if (getDepth(root.left) - getDepth(root.right) > 1) {
                    if (getDepth(root.left.left) > getDepth(root.left.right)) {
                        rightSpin(root);
                    } else {
                        leftRightSpin(root);
                    }
                }
            } else {
                throw new Exception("duplicate val");
            }
        }
        root.depth = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    /**
     * 节点高度，null为0
     */
    private int getDepth(TreeNode treeNode) {
        if (treeNode != null) {
            return treeNode.depth;
        }
        return 0;
    }


    /**
     * 删除节点
     */
    public void remove(int val) {
        doRemove(val, root, null);
    }

    private void doRemove(int val, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (val > root.val) {
            doRemove(val, root.right, root);
            if (getDepth(root.left) - getDepth(root.right) < -1) {
                if (getDepth(root.right.right) > getDepth(root.right.left)) {
                    leftSpin(root);
                } else {
                    rightLeftSpin(root);
                }
            }
        } else if (val < root.val) {
            doRemove(val, root.left, root);
            if (getDepth(root.left) - getDepth(root.right) > 1) {
                if (getDepth(root.left.left) > getDepth(root.left.right)) {
                    rightSpin(root);
                } else {
                    leftRightSpin(root);
                }
            }
//            当前节点就是要删除的节点
        } else {
//            选择一个子节点取代当前节点的位置
            if (root.left != null || root.right != null) {
//                如果左子树深度大，则从左子树取替身节点，减少旋转；反之从右子树取。
                TreeNode shadow;
                if (getDepth(root.left) > getDepth(root.right)) {
                    shadow = getRightMost(root.left);
                } else {
                    shadow = getLeftMost(root.right);
                }
                root.val = shadow.val;
//                shadow只有0或1个节点。
                doRemove(shadow.val, shadow, shadow.parent);
            } else {
                if (root == root.parent.left) {
                    root.parent.left = null;
                } else {
                    root.parent.right = null;
                }
                root.parent = null;
            }
        }
        root.depth = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    private TreeNode getLeftMost(TreeNode treeNode) {
        if (treeNode.left != null) {
            return getLeftMost(treeNode.left);
        } else {
            return treeNode;
        }
    }

    private TreeNode getRightMost(TreeNode treeNode) {
        if (treeNode.right != null) {
            return getRightMost(treeNode.right);
        } else {
            return treeNode;
        }
    }

}
