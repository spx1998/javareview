package Algorithms.S360_2019;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        if(n<3) System.out.println(-1);
        int[] lengths=new int[n];
        for(int i=0;i<n;i++){
            lengths[i]=scanner.nextInt();
        }
        scanner.close();
        int max =Math.max(lengths[0],Math.max(lengths[1],lengths[2]));
        int sum =lengths[0]+lengths[1]+lengths[2]-max;
        if((sum)>max) System.out.println(3);
        else {
            for (int i = 3; i < n; i++) {
                if(lengths[i]>max){
                    sum+=max;
                    max=lengths[i];
                }else {
                    sum+=lengths[i];
                }
                if(sum>max) {
                    System.out.println(i+1);
                    break;
                }
                else {
                    if(i==n-1)System.out.println(-1);
                }
            }
        }
    }
}
