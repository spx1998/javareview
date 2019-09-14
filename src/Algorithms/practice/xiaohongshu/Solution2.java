package Algorithms.practice.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

/**
 * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
 * 1.输入字符包括英文字符，"(" , ")" 和 "<"。
 * 2.英文字符表示笔记内容。
 * 3. (  ) 之间表示注释内容，任何字符都无效。 括号保证成对出现。
 * 4. "<" 表示退格, 删去前面一个笔记内容字符。 括号不受 "<" 影响 。
 * 例子:
 * a<<b((c)<)
 * b
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        int semaphore=0;
        for (char c : chars) {
            if (c == '<') {
                if (!stack.isEmpty()&&semaphore==0)
                    stack.pop();
            } else if (c == '(') {
                semaphore++;
            } else if (c == ')') {
                semaphore--;
            } else if (semaphore == 0) {
                stack.push(c);
            }
        }
        for(char c:stack){
            System.out.print(c);
        }

    }
}
