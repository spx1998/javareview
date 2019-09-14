package Algorithms.practice.xiaohongshu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小红书有很多用户。其中有些人会相互关注。互相关注的用户我们认为是朋友，朋友具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。朋友之间组成小红圈
 *
 * 给定一个 N * N 的矩阵 M，表示小红书的互相关注关系。如果M[i][j] = 1，表示已知第 i 个和 j 个用户互为关注，否则为单向关注或无关注；
 *
 * 所有的M[i][j]与M[j][i]相等，所有的M[i][i]=1;
 *
 * 请你输出所有用户中的小红圈数量。
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] relationship = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                relationship[i][j] = scanner.nextInt();
            }
        }
        int num = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0 ;i < n ;i ++){
            if(hashMap.get(i)==null){
                num++;
                hashMap.put(i,1);
            }
            for(int j=i+1;j<n;j++){
                if(relationship[i][j]==1) {
                    hashMap.putIfAbsent(j, 1);
                }
            }

        }
        System.out.println(num);
    }
}
