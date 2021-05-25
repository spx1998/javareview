package com.algorithms.leetcode.easy;

/**
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 我的解法：
 * 遍历数组中的元素，记录下此时的最大值和一个temp值，若temp+nums[i]>0,则temp = temp+nums[i]，否则temp = 0。
 * max = Math.max(max,temp).遍历完成后的max即结果。
 */
public class Solution53 {
    public static void main(String[] args) {
        System.out.println(new Solution53().maxSubArray(new int[]{-1,-1,-1}));
    }

    /**
     * 时间复杂度为n的方法
     * DP
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            max = Math.max(max, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }

    /**
     * 分治法
     * 时间复杂度也是O(n)，是线段树的基础。
     * 对于每个子区间记录四个值：
     * lSum 表示 [l, r][l,r] 内以 ll 为左端点的最大子段和
     * rSum 表示 [l, r][l,r] 内以 rr 为右端点的最大子段和
     * mSum 表示 [l, r][l,r] 内的最大子段和
     * iSum 表示 [l, r][l,r] 的区间和
     */

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return DFS(0, nums.length - 1, nums).mSum;
    }

    Status DFS(int left, int right, int[] nums) {
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }
        Status lSub = DFS(left, left + (right - left) / 2, nums);
        Status rSub = DFS(left + (right - left) / 2 + 1, right, nums);
        return pushUp(lSub, rSub);
    }


    private Status pushUp(Status lSub, Status rSub) {
        int inum = lSub.iSum + rSub.iSum;
        int lnum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rnum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mnum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);

        return new Status(lnum, rnum, mnum, inum);
    }

}
