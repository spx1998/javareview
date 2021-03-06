package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个 Trie (前缀树)，包含insert,search, 和startsWith这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母a-z构成的。
 * 保证所有输入均为非空字符串。
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Solution208().new Trie();
        trie.insert("abc");
    }
    class Trie {
        class TrieNode {
            TrieNode[] nextLetter = new TrieNode[26];
            boolean isEnd;

            public void setEnd() {
                isEnd = true;
            }
        }
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.nextLetter[c] == null) {
                    node.nextLetter[c] = new TrieNode();
                }
                node = node.nextLetter[c];
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (node.nextLetter[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                node = node.nextLetter[word.charAt(i) - 'a'];

            }
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                if (node.nextLetter[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                node = node.nextLetter[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

}
