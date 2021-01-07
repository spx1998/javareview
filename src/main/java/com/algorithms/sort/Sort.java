package com.algorithms.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 45779
 * 常见排序算法
 * 从小到大排序
 * 使用的数列：
 * 3 4 1 9 7 2 5 11
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 9, 7, 2, 5, 11};
        Sort test = new Sort();
//        test.bubbleSort1(array);
//        test.bubbleSort2(array);
//        test.bubbleSort3(array);
//        test.selectSort(array);
//        test.insertSort(array);
//        test.shellSort(array);
//        test.heapSort(array);
//        test.mergeSort(array);
//        test.quickSort(array);
//        System.out.println(Arrays.toString(array));
        //基数排序所用的序列： 125 361 88 170 291 66 103 234
//        int[] array2 = new int[]{125, 361, 88, 170, 291, 66, 103, 234};
//        test.radixSort(array2,1000);
//        test.mergeSort2(array);
        test.quickSort2(array);
        System.out.println(Arrays.toString(array));
    }


    //交换两元素的位置
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //最简单的冒泡排序（不是真正的冒泡排序）
    public void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    //正宗的冒泡排序
    private void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    //改进后的冒泡算法：如果已经排好序，则停止循环
    private void bubbleSort3(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    flag = true;
                }
            }
        }
    }

    //简单选择排序
    private void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    //直接插入排序
    private void insertSort(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                int j = i - 1;
                for (; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    //希尔排序：要求原数组基本有序，效率才高。
    private void shellSort(int[] array) {
        int increment = array.length;
        do {
            increment = increment / 3 + 1;
            for (int i = increment; i < array.length; i++) {
                if (array[i] < array[i - increment]) {
                    int temp = array[i];
                    int j = i - increment;
                    for (; j >= 0 && temp < array[j]; j -= increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = temp;
                }
            }
        } while (increment > 1);
    }

    //堆排序
    private void heapSort(int[] array) {
        //构建大顶堆
        for (int i = array.length / 2; i > 0; i--) {
            heapAdjust(array, i, array.length);
        }
        //排序：1）将堆顶记录与未排序序列的最后一个记录交换；2）重新生成大顶堆
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapAdjust(array, 1, i);
        }
    }

    //生成大顶堆
    private void heapAdjust(int[] array, int i, int j) {
        int temp = array[i - 1];
        for (int a = i * 2; a <= j; a *= 2) {
            if (a < j && array[a - 1] < array[a]) {
                a++;
            }
            if (temp > array[a - 1])
                break;
            array[i - 1] = array[a - 1];
            i = a;
        }
        array[i - 1] = temp;
    }

    //归并排序
    private void mergeSort(int[] array) {
        mSort(array, array, 0, array.length - 1);
    }

    private void mSort(int[] compareArray, int[] sortArray, int s, int t) {
        if (s == t)
            sortArray[s] = compareArray[s];
        else {
            int[] sArray = new int[10];
            int m = (s + t) / 2;
            mSort(compareArray, sArray, s, m);
            mSort(compareArray, sArray, m + 1, t);
            merge(sArray, sortArray, s, m, t);
        }
    }

    //s是此次归并的启点 m是归并区间的中间点，t是终点： start mid tail
    private void merge(int[] orginArray, int[] sortArray, int s, int m, int t) {
        int j, k, l;
        for (k = s, j = m + 1; s <= m && j <= t; k++) {
            if ((orginArray[s] < orginArray[j])) {
                sortArray[k] = orginArray[s++];

            } else sortArray[k] = orginArray[j++];
        }
        if (s <= m) {
            for (l = 0; l <= m - s; l++) {
                sortArray[k++] = orginArray[s + l];
            }
        }
        if (j <= t) {
            for (l = 0; l <= t - j; l++) {
                sortArray[k++] = orginArray[j + l];
            }
        }
    }

    //快速排序
    private void quickSort(int[] array) {
        qSort(array, 0, array.length - 1);
    }

    private void qSort(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(array, low, high);
            qSort(array, low, pivot - 1);
            qSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivotKey = array[low];
        while (low < high) {
            while (low < high && array[high] > pivotKey)
                high--;
            swap(array, low, high);
            while (low < high && array[low] <= pivotKey)
                low++;
            swap(array, low, high);
        }
        return low;
    }

    //基数排序
    private void radixSort(int[] array, int n) {
        int[] tempArray = new int[10];
        int k = 0;
        for (int x = 10; x <= n; ) {
            int[][] array2 = new int[10][array.length];
            for (int value : array) {
                int temp = value / (x / 10) % 10;
                array2[temp][tempArray[temp]] = value;
                tempArray[temp]++;
            }
            for (int i = 0; i < 10; i++) {
                if (tempArray[i] != 0) {
                    for (int j = 0; j < tempArray[i]; j++) {
                        array[k] = array2[i][j];
                        k++;
                    }
                    tempArray[i] = 0;
                }
            }
            k = 0;
            x *= 10;
        }
    }

    //归并排序的非递归实现
    private void mergeSort2(int[] array) {
        int[] sortArray = new int[array.length];
        int k = 1;
        while (k < array.length) {
            mergePass(array, sortArray, k, array.length);
            k *= 2;
            mergePass(sortArray, array, k, array.length);
            k *= 2;
        }
    }

    private void mergePass(int[] array, int[] sortArray, int k, int length) {
        int i = 0;
        int j;
        while (i <= length - 2 * k) {
            merge(array, sortArray, i, i + k - 1, i + 2 * k - 1);
            i = i + 2 * k;
        }
        if (i < length - k)
            merge(array, sortArray, i, i + k - 1, length - 1);
        else
            for (j = i; j < length; j++) {
                sortArray[j] = array[j];
            }
    }

    //快速排序的非递归实现
    private void quickSort2(int[] array) {
        if (array == null)
            return;
        qSort2(array, 0, array.length - 1);
    }

    private void qSort2(int[] a, int low, int high) {
        int pivot;
        if (low >= high)
            return;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = partition(a, low, high);
            // 先压low,再压high
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

}
