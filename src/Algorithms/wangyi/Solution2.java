package Algorithms.wangyi;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.close();
        String reverse =new StringBuilder(String.valueOf(n)).reverse().toString();
        System.out.println(n+Integer.parseInt(reverse));
    }
}
