package Algorithms.practice.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组，求其中和小于k的三元组个数（三个数字）。
 * 6 2
 * -2 0 1 2 3 6
 * 输出： 4
 *
 * 先排序，双指针 时间复杂度n^2.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ints = new int[n];
        for(int i=0;i<n;i++){
            ints[i] = scanner.nextInt();
        }
        int count = 0;
        scanner.close();
        Arrays.sort(ints);
        for(int i=0;i<n-2;i++){
            if(i>0&&ints[i]==ints[i-1])
                continue;
            int x = i+1;
            int y = ints.length-1;
            while (x<y){
                if(x-1!=i&&ints[x]==ints[x-1]){
                    x++;
                    continue;
                }else if(ints[x]+ints[y]<k-ints[i]){
                    count++;
                    x++;
                }else {
                    y--;
                }
            }
        }
        System.out.println(count);
    }
}
