package Algorithms.JZoffer;

import java.util.Scanner;

public class Solution67 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(cutRope(scanner.nextInt()));
        }
    }
    public static int cutRope(int target) {
        int[] dp = new int[target+1];
        dp[1]=1;
        dp[2]=1;
        if(target+1>3)dp[3]=2;
        if(target+1>4)dp[4]=4;
        if(target+1>5)dp[5]=6;
        if(target+1>6)dp[6]=9;
        for(int i=7;i<=target;i++){
            dp[i]=Math.max(dp[i-2]*2,dp[i-2]*3);
        }
        return dp[target];
    }
}
