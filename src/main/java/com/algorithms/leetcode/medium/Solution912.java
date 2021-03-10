package com.algorithms.leetcode.medium;

public class Solution912 {


    public void selectSort(int[] nums) {
        int min;
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    temp = j;
                }
            }
            swap(nums, i, temp);
        }
    }

    //    改进：设置一个标志，标志上次遍历是否有交换，如果没有说明已经完成排序，退出循环。
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                nums[j + 1] = nums[j];
                if (temp > nums[j]) {
                    nums[j + 1] = temp;
                    break;
                }
                if (j == 0) {
                    nums[j] = temp;
                }
            }
        }
    }

    public void shellSort(int[] nums) {
        for (int d = nums.length / 2; d >= 1; d = d / 2) {
            for (int i = 0; i < d; i++) {
                int temp;
                for (int j = i; j < nums.length; j += d) {
                    temp = nums[j];
                    for (int k = j - d; k >= 0; k -= d) {
                        nums[k + d] = nums[k];
                        if (nums[k] < temp) {
                            nums[k + d] = temp;
                            break;
                        }
                        if (k - d < 0) {
                            nums[k] = temp;
                        }
                    }
                }
            }
        }
    }

    public void heapSort(int[] arr) {
    }

    public static void main(String[] args) {
        new Solution912().mergeSort(new int[]{-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39});
    }

    public void mergeSort(int[] nums) {
        for (int step = 2; step < nums.length * 2; step *= 2) {
            for (int start = 0, end = step;
                 start < nums.length;
                 start = end, end += step) {
                int length = step / 2;
                if (end > nums.length) {
                    end = nums.length;
                }
                doSort(nums, length, start, end);
            }
        }
    }

    private void doSort(int[] nums, int length, int start, int end) {
        if (end - length - start <= 0) {
            return;
        }
        int[] arr1 = new int[length];
        int[] arr2 = new int[end - length - start];
        System.arraycopy(nums, start, arr1, 0, length);
        System.arraycopy(nums, start + length, arr2, 0, end - length - start);
        int i = 0, j = 0;
        for (int index = start; index < end; index++) {
            if (arr1[i] < arr2[j]) {
                nums[index] = arr1[i];
                i++;
                if (i == arr1.length) {
                    System.arraycopy(arr2, j, nums, index + 1, arr2.length - j);
                    break;
                }
            } else {
                nums[index] = arr2[j];
                j++;
                if (j == arr2.length) {
                    System.arraycopy(arr1, i, nums, index + 1, arr1.length - i);
                    break;
                }
            }
        }
    }

    public void quickSort(int[] arr) {

    }


    //交换两元素的位置
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
