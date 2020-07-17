package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 我的解法：双指针，先将数组排序，然后从小到大取每个元素作为三元组的第一个元素，下一元素作为第二个元素，数组最后一个元素作为第三个元素。
 * 如果当前和大于0则第三个元素前移，小于0则第二个元素后移，等于0则取得一种解。比起暴力解法O（n^3）的时间复杂度，这种算法的时间复杂度为n*n。
 * <p>
 * 其他解法：暴力解法，时间复杂度较高。
 */
public class Solution15 {
    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[nums.length - 1] < 0) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            if (nums[i] == 0) {
                if (i < nums.length - 2 && nums[i + 1] == 0 && nums[i + 2] == 0) {
                    lists.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
                    continue;
                }
            }
            int a = i + 1;
            int b = nums.length - 1;
            while (a < b) {
                int temp = nums[i] + nums[a] + nums[b];
                if (temp == 0) {
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[a], nums[b])));
                    a++;
                    b--;
                    //处理a++=a或者b--=b的情况。
                    while (a != nums.length - 1 && nums[a] == nums[a - 1]) {
                        a++;
                    }
                    while (b != nums.length - 1 && b != -1 && nums[b] == nums[b + 1]) {
                        b--;
                    }
                } else if (temp < 0) {
                    a++;
                } else {
                    b--;
                }

            }
        }
        return lists;
    }
}
