package com.algorithms.leetcode.LCP;

import java.util.Arrays;

/**
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 */
public class Solution28 {
    public static void main(String[] args) {
        int i = new Solution28().purchasePlans(new int[]{93704, 67017, 80652, 68278, 71978, 30128, 5179, 49467, 44044, 45183},
                85962);
        System.out.println(i);
    }

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        long res = 0;
        while (left < right) {
            int i = target - nums[left];
            int index = getIndex(nums, left, right, i);
            if (index == -1) {
                return (int) (res % 1000000007);
            }
            res += (index - left);
            right = index;
            left++;
        }
        return (int) (res % 1000000007);
    }

    private int getIndex(int[] nums, int left, int right, int i) {
        while (left <= right) {
            int temp = left + (right - left) / 2;
            if (nums[temp] > i) {
                right = right - 1;
            } else {
                if (temp + 1 >= nums.length || nums[temp + 1] > i) {
                    return temp;
                }
                left = temp + 1;
            }
        }
        return -1;
    }
}
