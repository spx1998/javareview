package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//        优化：d的取值和算法
        for (int d = nums.length / 2; d >= 1; d = d / 2) {
//                优化：1）和2）不需要拆成两个for循环，从第一个元素开始逐个遍历一次即可，
//            1）
            for (int i = 0; i < d; i++) {
                int temp;
//                2）
                for (int j = i; j < nums.length; j += d) {
//                    int temp;
//                    for (int i = 0; i < nums.length; i++) {
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

    public static void main(String[] args) {
        int[] ints = {5, 1, 1, 2, 0, 0};
        new Solution912().heapSort(ints);
        Arrays.stream(ints).boxed().forEach(System.out::println);
    }

    public void heapSort(int[] nums) {
//        构建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            sink(i, nums, nums.length);
        }
//        逐个交换，堆中最大的元素移到数组后，重新构建大顶堆。
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            sink(0, nums, nums.length - 1 - i);
        }
    }

    public void sink(int index, int[] nums, int border) {
        while (index * 2 < border) {
            if (index * 2 + 1 >= border) {
                if (nums[index] < nums[index * 2]) {
                    swap(nums, index, index * 2);
                } else {
                    break;
                }
            } else {
                int swapIndex = nums[2 * index] > nums[2 * index + 1] ? 2 * index : 2 * index + 1;
                if (nums[index] < nums[swapIndex]) {
                    swap(nums, index, swapIndex);
                    index = swapIndex;
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 迭代实现；
     * 递归实现伪代码：
     * sort(a,b,arr){
     * sort(a,(a+b)/2,arr);
     * sort((a+b)/2,b,arr);
     * merge(a,(a+b)/2,b,arr);
     * }
     */
    public void mergeSort(int[] nums) {
        for (int step = 2; step < nums.length * 2; step *= 2) {
            for (int start = 0, end = step;
                 start < nums.length;
                 start = end, end += step) {
                int length = step / 2;
                if (end > nums.length) {
                    end = nums.length;
                }
                doMergeSort(nums, length, start, end);
            }
        }
    }

    private void doMergeSort(int[] nums, int length, int start, int end) {
        if (end - length - start <= 0) {
            return;
        }
//        优化：全局只用一个辅助数组，空间复杂度为O(n)
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


    public void quickSort(int[] nums) {
//        优化：最好传前闭后闭的区间，容易处理得多。
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(nums, start, end);
//        要注意元素相等导致的无限循环，所以每次跳过中间的partition元素。
        doQuickSort(nums, start, partition - 1);
        doQuickSort(nums, partition + 1, nums.length);
    }

    private int partition(int[] nums, int start, int end) {
        int midVal = nums[start];
        while (start < end) {
//            防止数组越界
            while (start < end && nums[end] > midVal) {
                end--;
            }
            swap(nums, start, end);
            while (start < end && nums[start] <= midVal) {
                start++;
            }
            swap(nums, start, end);
        }
        return start;
    }

    //交换两元素的位置
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void countingSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int min = nums[0];
        int max = nums[0];
        for (int k : nums) {
            if (k > max) {
                max = k;
            }
            if (k < min) {
                min = k;
            }
        }
        int[] countArray = new int[max - min];
        for (int num : nums) {
            countArray[num - min] += 1;
        }
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = countArray[i]; j > 0; j--) {
                nums[index] = i + min;
                index++;
            }
        }
    }

    public void bucketSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int min = nums[0];
        int max = nums[0];
        for (int k : nums) {
            if (k > max) {
                max = k;
            }
            if (k < min) {
                min = k;
            }
        }
//        一个桶的大小设为5。
        int bucketSize = 5;
        int[][] buckets = new int[(max - min) / bucketSize + 1][0];
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            int[] bucket = buckets[index];
            bucket = Arrays.copyOf(bucket, bucket.length + 1);
            bucket[bucket.length - 1] = num;
            buckets[index] = bucket;
        }
        int index = 0;
        for (int[] arr : buckets) {
//            每个桶内可以用插入排序，这里是简略写法
            Arrays.sort(arr);
            for (int num : arr) {
                nums[index] = num;
                index++;
            }
        }
    }

    //    基数排序
    public void radixSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int k : nums) {
            if (k > max) {
                max = k;
            }
            if (k < min) {
                min = k;
            }
        }
        int temp = Math.max(Math.abs(min), Math.abs(max));
        int digit = 0;
        while (temp != 0) {
            digit++;
            temp = temp / 10;
        }
        int[][] buckets = new int[10][0];
        int index;
        for (int i = 0; i < digit; i++) {
            for (int num : nums) {
//                取当前位的值
                int val = Math.abs(num / (int) (Math.pow(10, i)) % 10);
                int[] bucket = buckets[val];
                bucket = Arrays.copyOf(bucket, bucket.length + 1);
                bucket[bucket.length - 1] = num;
            }
            index = 0;
            for (int[] bucket : buckets) {
                for (int k : bucket) {
                    nums[index] = k;
                    index++;
                }
            }
        }
//        区分正负数
        index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = buckets[i].length; j >= 0; j--) {
                if (buckets[i][j] < 0) {
                    nums[index] = buckets[i][j];
                    index++;
                }
            }
        }
        for (int[] bucket : buckets) {
            for (int k : bucket) {
                if (k >= 0) {
                    nums[index] = k;
                    index++;
                }
            }
        }
    }
}
