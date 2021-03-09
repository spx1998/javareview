package com.algorithms.sort;

import java.util.Arrays;

public class Sort2 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 9, 7, 2, 5, 11};
        Sort2 sort2 = new Sort2();
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
//        test.quickSort2(array);
        System.out.println(Arrays.toString(array));
    }


    public void selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            int temp = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    temp = j;
                }
            }
            swap(arr, i, temp);
        }
    }

    //    改进：设置一个标志，标志上次遍历是否有交换，如果没有说明已经完成排序，退出循环。
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                arr[j + 1] = arr[j];
                if (temp > arr[j]) {
                    arr[j + 1] = temp;
                    break;
                }
                if (j == 0) {
                    arr[j] = temp;
                }
            }
        }
    }

    public void shellSort(int[] arr) {

    }

    public void heapSort(int[] arr) {

    }

    public void mergeSort(int[] arr) {

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
