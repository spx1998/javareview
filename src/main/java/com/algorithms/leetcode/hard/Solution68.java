package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于maxWidth。
 * 输入单词数组 words至少包含一个单词。
 * 示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What  must  be",
 * "acknowledgment ",
 * "shall be    "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science is what we",
 * "understand   well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do         "
 * ]
 *
 * 我的解法：
 * 依照题意解答即可：14ms ^^
 */
public class Solution68 {
    public static void main(String[] args) {
        new Solution68().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int temp;
            if (start == i) {
                temp = words[i].length();
            } else {
                temp = words[i].length() + 1;
            }
            if (sum + temp > maxWidth) {
                result.add(generateRow(words, start, i - 1, maxWidth, sum, false));
                start = i;
                sum = words[i].length();
            } else {
                sum += temp;
            }
        }
        result.add(generateRow(words, start, words.length-1, maxWidth, sum, true));
        return result;
    }

    private String generateRow(String[] words, int start, int end, int maxWidth, int sum, boolean isLastRow) {
        int count = start != end ? (maxWidth - sum) / (end - start)+1 : 0;
        int remainder = start != end ? (maxWidth - sum) % (end - start) : 0;
        String[] strings = new String[end - start + 1];
        System.arraycopy(words, start, strings, 0, end - start + 1);
        if (isLastRow || count == 0) {
            String s = String.join(" ", strings);
            return s + String.join("", Collections.nCopies(maxWidth - sum, " "));
        }
        String interval = String.join("", Collections.nCopies(count, " "));
        if (remainder == 0) {
            return String.join(interval, strings);
        } else {
            String[] head = new String[remainder];
            String[] tail = new String[end - start - remainder + 1];
            System.arraycopy(words, start, head, 0, remainder);
            System.arraycopy(words, start+remainder, tail, 0, end - start - remainder + 1);

            return String.join(interval + " ", head) + interval+" " + String.join(interval, tail);
        }
    }

}
