package com.algorithms.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 我的解法：二分法
 * temp处的值大于pre处的值，则最小值在temp右侧，反之在左侧。
 * 每次验证temp-1 ，temp ，temp+1的大小关系，若存在后者小于前者，则后者即最小值。
 * 需要注意的是边界情况，例如[1,2][2,1]等数组，容易进入死循环，为了避免第一种情况，需要判断数组是否进行了旋转，若没有，则直接返回nums[0].
 *
 * 相关问题 leetcode第33题 {@link Solution33}
 */
public class Solution153 {
    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = 0;
        int tail = nums.length - 1;
        if (nums[tail] > nums[0]) {
            return nums[0];
        }
        while (pre <= tail) {
            int temp = pre + (tail - pre) / 2;
            if (temp != 0 && nums[temp] < nums[temp - 1]) {
                return nums[temp];
            }
            if (temp != nums.length - 1 && nums[temp] > nums[temp + 1]) {
                return nums[temp + 1];
            }
            if (nums[temp] < nums[pre]) {
                tail = temp - 1;
            } else {
                pre = temp + 1;
            }
        }
        return nums[0];
    }
}
