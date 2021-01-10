package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 示例1：
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * 解法1：
 * hash表
 * 解法2：
 * 三分之一和三分之二处的元素。但是需要验证，是否超过n/3。
 * 解法3：
 * 摩尔投票法,投票选举两个候选人，选出后需要验证是否超过n/3。
 * 相关问题：
 * leetcode 第169题 {@link com.algorithms.leetcode.easy.Solution169}
 */
public class Solution229 {
    public static void main(String[] args) {
        System.out.println(new Solution229().majorityElement(new int[]{1, 2, 3}));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int cand1 = nums[0];
        int cand2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                cand1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                cand2 = num;
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
            } else if (cand2 == num) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }
        return res;
    }
}
