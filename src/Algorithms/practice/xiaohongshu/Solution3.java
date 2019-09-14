package Algorithms.practice.xiaohongshu;

import java.util.Scanner;

/**
 * 薯队长写了n篇笔记， 编号从 1～n，每篇笔记都获得了不少点赞数。 薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
 * 1.    不能出现连续编号的笔记。
 * 2.    总点赞总数最多
 * 如果满足 1，2条件有多种方案，挑选笔记总数最少的那种。
 * 输出两个整数x y。空格分割。
 * x 表示总点赞数，y表示挑选的笔记总数。
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for(int i=0;i<n;i++){
            score[i]=scanner.nextInt();
        }
        scanner.close();
        int[] dp = new int[n+1];
        int[] num = new int[n+1];
        dp[1] = score[0];
        dp[2] = Math.max(score[0], score[1]);
        num[1]=1;
        num[2]=1;
        for(int i=3;i<n+1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+score[i-1]);
            if(dp[i]==dp[i-1]){
                num[i]=num[i-1];
            }else num[i] = num[i-2]+1;
        }
        System.out.println(dp[n]+" "+num[n]);
    }
}
