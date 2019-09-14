package Algorithms.leetcode;

import java.util.Arrays;

/**
 *
 * lis问题
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 动态规划 n^2
 * 动态规划与二分查找结合  nlogn
 */
public class Solution300 {
    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        for(int i=nums.length-2;i>=0;i--){
            int max = 1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    max = Math.max(max,1+dp[j]);
                }
            }
            dp[i] = max;
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
}
