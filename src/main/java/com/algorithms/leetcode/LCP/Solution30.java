package com.algorithms.leetcode.LCP;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，
 * 其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，
 * 每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 *
 * 解法：
 * 贪心+优先队列
 */
public class Solution30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        int i = new Solution30().magicTower(ints);
        System.out.println(i);

    }

    public int magicTower(int[] nums) {
        long sum = 1;
        for (int j : nums) {
            sum += j;
        }
        if (sum <= 0) return -1; //算出所有回合
        sum = 1;

        int res = 0;
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int j : nums) {
            if (j < 0) {
                priority.offer(j);
            }
            sum += j;
            if (sum <= 0) {
                int smallest = priority.poll();
                list.add(smallest);
                sum -= smallest;
                res++;
            }
        }
        for (int num : list) {
            sum += num;
        }
        return sum > 0 ? res : -1;
    }


}
