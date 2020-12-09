package com.algorithms.leetcode.medium;


import com.algorithms.datastructure.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * 提示：
 * 节点数不超过 100 。
 * 每个节点值Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 *
 * 我的解法：
 * DFS
 * 相关问题：
 * leetcode 第138题 {@link Solution138}
 */
public class Solution133 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = new ArrayList<>();
        node2.neighbors = new ArrayList<>();
        node3.neighbors = new ArrayList<>();
        node4.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        new Solution133().cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> visitMap = new HashMap<>();
        return deepCopy(node, visitMap);
    }

    private Node deepCopy(Node node, Map<Integer, Node> visitMap) {
        Node copy = new Node(node.val);
        visitMap.put(copy.val, copy);
        List<Node> copyNeighbors = new ArrayList<>();
        for (Node subNode : node.neighbors) {
            if (visitMap.get(subNode.val) == null) {
                Node deepCopy = deepCopy(subNode, visitMap);
                copyNeighbors.add(deepCopy);
            } else {
                copyNeighbors.add(visitMap.get(subNode.val));
            }
        }
        copy.neighbors = copyNeighbors;
        return copy;
    }
}
