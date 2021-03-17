package com.algorithms.leetcode.medium;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * TODO 题解
 */
public class Solution211 {
    class WordDictionary {
        Node root;

        class Node {
            Node[] letters = new Node[26];
            boolean end = false;

            public void setEnd() {
                end = true;
            }

            public boolean isEnd() {
                return end;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Node node = root;
            for (char c : chars) {
                if (node.letters[c - 'a'] == null) {
                    node.letters[c - 'a'] = new Node();
                }
                node = node.letters[c - 'a'];
            }
            node.setEnd();
        }

        public boolean search(String word) {
            if (word.charAt(0) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (root.letters[i] != null) {
                        if (doSearch(word.substring(1), root.letters[i])) {
                            return true;
                        }
                    }
                }
            } else {
                return doSearch(word, root);
            }
            return false;
        }

        private boolean doSearch(String word, Node node) {
            if ("".equals(word)) {
                return node.isEnd();
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (node.letters[j] != null) {
                            if (doSearch(word.substring(i + 1), node.letters[j])) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    if (node.letters[word.charAt(i) - 'a'] == null) {
                        return false;
                    } else {
                        node = node.letters[word.charAt(i) - 'a'];
                    }
                }
            }
            return node.isEnd();
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
