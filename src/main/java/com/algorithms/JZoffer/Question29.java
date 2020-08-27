package com.algorithms.JZoffer;

import java.util.ArrayList;

public class Question29 {
    public static void main(String[] args) {
        Question29 question29 = new Question29();
        int[] ints = {2,5,9,7,1,3};
        question29.GetLeastNumbers_Solution(ints,2);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input==null||k>input.length)return arrayList;
        bubbleSort(input);
        for(int i=0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private void bubbleSort(int[] array){
        boolean flag = true;
        for(int i=0;i<array.length&&flag;i++){
            flag = false;
            for(int j = array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    flag = true;
                    swap(array,j-1,j);
                }
            }
        }
    }
    private void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int min = i;
            for (int j=i;j<array.length;j++){
                if(array[j]<array[i]){
                    min = j;
                }
            }
            swap(array,i,min);
        }
    }
    private void insertSort(int[]array){
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                int temp = array[i];
                int j;
                for( j=i-1;j>=0&&array[j]>temp;j--){
                    array[j] = array[j+1];
                }
                array[j+1] = temp;
            }
        }
    }
    private void shellSort(int[]array){
        int increment = array.length;
        do{
            increment = increment/3+1;
            for(int i = increment;i<array.length;i+=increment){
                if(array[i]<array[i-increment]){
                    int temp = array[i];
                    int j = i-increment;
                    for(;j>=0&&array[j]>temp;j-=increment){
                        array[j] = array[j+increment];
                    }
                    array[j+increment] = temp;
                }
            }
        }while (increment>1);

    }
    private void heapSort(int[] array){
        for(int i=array.length/2;i>0;i--){
            heapAdjust(array,i,array.length);
        }
        for(int i=array.length;i>0;i--){
            swap(array,0,i);
            heapAdjust(array,1,i);
        }
    }

    private void heapAdjust(int[] array, int i, int j) {
        int temp = array[i-1];
        for(int a=i*2;a<j;a*=2){
            if(array[a+1]>array[a]){
                a=a+1;
            }
            if(temp>array[a-1])
                break;
            array[i-1] = array[a-1];
            i = a;
        }
        array[i-1] = temp;
    }
    private void mergeSort(int[] array){
        mSort(array,array,0,array.length-1);
    }

    private void mSort(int[] sortArray, int[] compareArray, int pre, int end) {
        if(pre==end){
            sortArray[pre] = compareArray[pre];
        }else {
            int mid =(pre+end)/2;
            int[] sSort = new int[compareArray.length];
            mSort(sSort,compareArray,pre,mid);
            mSort(sSort,compareArray,mid+1,end);
            merge(sortArray,sSort,pre,mid,end);
        }
    }

    private void merge(int[] sortArray, int[] sSort, int pre, int mid, int end) {
        int j,k,l;
        for(l=j=pre,k=mid+1;j<=mid&&k<=end;l++){
            if(sSort[j]<=sSort[k]){
                sortArray[l]=sSort[j];
                j++;
            }
            else {
                sortArray[l] = sSort[k];
                k++;
            }
        }
        if(j<mid){
            for(;j<=mid;j++){
                sortArray[l++] = sSort[j];
            }
        }
        if(k<end){
            for(;k<=end;k++){
                sortArray[l++] = sSort[k];
            }
        }
    }
    private void quickSort(int[] array){
        qSort(array,0,array.length-1);
    }

    private void qSort(int[] array, int low, int high) {

      if(low<high){
          int pivot = partition(array,low,high);
          qSort(array,low,pivot-1);
          qSort(array,pivot+1,high);
      }
    }

    private int partition(int[] array, int low, int high) {
        int pivotKey = array[low];
       while (low<high){
           while (array[high]>pivotKey)
               high--;
           swap(array,low,high);
           while (array[low]<pivotKey)
               low++;
           swap(array,low,high);
       }
       return low;
    }

}