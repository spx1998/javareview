package Algorithms.practice.tongcheng58;

import java.util.Scanner;

/**
 * 小朋友排一列，每人对应一个score，每人至少发一个糖果。且要求，相邻的两个小朋友，score高的所得糖果一定比分值低的多。问最少要发多少糖果。
 * 思路： score数组正向遍历一次，逆向遍历一次。
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] score = new int[n];
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            score[i]=scanner.nextInt();
        }
        scanner.close();
        for(int i=0;i<n;i++){
            nums[i]=1;
        }
        int increment=1;
        //先正向遍历
        for(int i=1;i<n;i++){
            if(score[i]>score[i-1]){
                nums[i] += increment;
                increment++;
            }else {
                increment=1;
            }
        }
        //逆向遍历
        for(int i=n-2;i>=0;i--){
            if(score[i]>score[i+1]&&nums[i]<=nums[i+1]){
                nums[i] = 1+nums[i+1];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        System.out.println(sum);
    }
}
