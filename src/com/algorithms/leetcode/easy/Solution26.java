package com.algorithms.leetcode.easy;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 我的解法：暴力解法
 * 双指针解法：
 * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。
 * 只要 nums[i]=nums[j]，我们就增加 j 以跳过重复项。
 * 当我们遇到 nums[j] != nums[i] 时，跳过重复项的运行已经结束，
 * 因此我们必须把它（nums[j]）的值复制到 nums[i+1]。
 * 然后递增 i，接着我们将再次重复相同的过程，直到 j到达数组的末尾为止。
 * <p>
 * 相关问题：
 * * leetcode27题：{@link Solution27}
 */
public class Solution26 {
    public static void main(String[] args) {

        new Solution26().removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    for (int k = i + 1; k < j; k++) {
                        nums[k] = nums[j];
                    }
                    length++;
                    break;
                }
            }
        }
        return length;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
