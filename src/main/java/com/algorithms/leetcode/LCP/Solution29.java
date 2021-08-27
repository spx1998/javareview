package com.algorithms.leetcode.LCP;

/**
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，
 * 每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 * 为保证声乐混合效果，成员站位规则为：自 grid
 * 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 */
public class Solution29 {
    public static void main(String[] args) {
        int i = new Solution29().orchestraLayout(449572,
                209397,
                306801
        );
        System.out.println(i);
    }

    public int orchestraLayout(int num, int xPos, int yPos) {
        int a = xPos;
        int b = yPos;
        int c = num - 1 - xPos;
        int d = num - 1 - yPos;
        int outer = Math.min(a, Math.min(b, Math.min(c, d)));
        long count = 0;
        for (int i = 0; i < outer; i++) {
            count = count + (num - 1 - i * 2L) * 4;
        }
        if (xPos == outer) {
            count += yPos - outer + 1;
        } else if (yPos == outer) {
            count += (num - 1 - outer * 2L) * 4 - (xPos - outer - 1);
        } else if (xPos == num - outer - 1) {
            count += (num - 1 - outer * 2L) * 3 - (yPos - outer - 1);
        } else {
            count += (num - 1 - outer * 2L) + xPos - outer + 1;
        }
        return (int) (count % 9) == 0 ? 9 : (int) (count % 9);
    }
}
