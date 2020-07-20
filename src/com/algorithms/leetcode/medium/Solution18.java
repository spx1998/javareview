package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 我的解法：双指针， 在Solution15外加一层循环。
 */
public class Solution18 {
    public static void main(String[] args) {
        new Solution18().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target / 4) {
                return lists;
            } else if (nums[i] == target / 4 && target % 4 == 0 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2] && nums[i] == nums[i + 3]) {
                {
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[i], nums[i], nums[i])));
                }
            } else {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = j + 1;
                    int l = nums.length - 1;
                    while (k < l) {
                        int temp = nums[i] + nums[j] + nums[k] + nums[l];
                        if (temp == target) {
                            lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                            k++;
                            l--;
                            //处理a++=a或者b--=b的情况。
                            while (k != nums.length - 1 && nums[k] == nums[k - 1]) {
                                k++;
                            }
                            while (l != nums.length - 1 && l != -1 && nums[l] == nums[l + 1]) {
                                l--;
                            }
                        } else if (temp < target) {
                            k++;
                        } else {
                            l--;
                        }
                    }

                }
            }
        }
        return lists;

    }
}
