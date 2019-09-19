package Algorithms.practice.ByteDance;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int x = scanner.nextInt();
        int[][] value = new int[n][2];
        for(int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                value[i][j]=scanner.nextInt();
            }
        }
        scanner.close();
        int[][] dp =new int[n][x];
        for(int i=0;i<n;i++){

        }
    }
}
