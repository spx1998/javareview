package com.algorithms.leetcode.hard;

import com.algorithms.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 */
public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                sb.append("n,");
            } else {
                sb.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.charAt(0) == 'n') {
            return null;
        }
        TreeNode root = null, temp = null;
        boolean left = true;
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        for (String s : split) {
            if (root == null) {
                root = new TreeNode(Integer.parseInt(s));
                queue.offer(root);
                continue;
            }
            if (left) {
                temp = queue.poll();
                if (!"n".equals(s)) {
                    temp.left = new TreeNode(Integer.parseInt(s));
                    queue.offer(temp.left);
                }
            } else {
                if (!"n".equals(s)) {
                    temp.right = new TreeNode(Integer.parseInt(s));
                    queue.offer(temp.right);
                }

            }
            left = !left;
        }
        return root;
    }
}
