package Algorithms.S360_2019;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int j=0;j<n;j++){
            a[j]=scanner.nextInt();
        }
        for(int j=n-1;j>=0;j--){
            b[j]=scanner.nextInt();
        }
        scanner.close();
        int[][] lcs=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                if (a[i - 1] != b[j - 1]) {
                    lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1]
                            : lcs[i - 1][j];
                }
            }
        }
        System.out.println(lcs[n][n]);

    }
}
