package Algorithms.sort;

import java.util.Arrays;

/**
 * @author 45779
 * 常见排序算法
 * 从小到大排序
 * 使用的数列：
 * 3 4 1 9 7 2 5 11
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,9,7,2,5,11};
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
        int[] array2 = new int[]{125, 361, 88, 170, 291, 66, 103, 234};
        test.radixSort(array2,1000);
        System.out.println(Arrays.toString(array2));
    }



    //交换两元素的位置
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //最简单的冒泡排序（不是真正的冒泡排序）
    public void bubbleSort1(int[] array){
        for (int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    swap(array,i,j);
                }
            }
        }
    }
    //正宗的冒泡排序
    private void bubbleSort2(int[] array) {
        for(int i=0;i<array.length;i++){
            for (int j=array.length-1;j>i;j--){
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }
    //改进后的冒泡算法：如果已经排好序，则停止循环
    private void bubbleSort3(int[] array){
        boolean flag = true;
        for(int i=0;i<array.length&&flag;i++){
            flag = false;
            for (int j=array.length-1;j>i;j--){
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                    flag = true;
                }
            }
        }
    }
    //简单选择排序
    private void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int min = i;
            for (int j=i+1;j<array.length;j++){
                if(array[min]>array[j]){
                    min = j;
                }
            }
            swap(array,i,min);
        }
    }
    //直接插入排序
    private void insertSort(int[] array){
        int temp = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                temp = array[i];
                int j=i-1;
                for(;j>=0&&array[j]>temp;j--){
                    array[j+1]=array[j];
                }
                array[j+1]=temp;
            }
        }
    }
    //希尔排序：要求原数组基本有序，效率才高。
    private void shellSort(int[] array){
        int increment = array.length;
        do{
            increment = increment/3+1;
            for(int i= increment;i<array.length;i++){
                if(array[i]<array[i-increment]){
                    int temp = array[i];
                    int j=i-increment;
                    for(;j>=0&&temp<array[j];j-=increment){
                        array[j+increment]=array[j];
                    }
                    array[j+increment] = temp;
                }
            }
        }while (increment>1);
    }
    //堆排序
    private void heapSort(int[] array){
        //构建大顶堆
        for(int i=array.length/2;i>0;i--){
            heapAdjust(array,i,array.length);
        }
        //排序：1）将堆顶记录与未排序序列的最后一个记录交换；2）重新生成大顶堆
        for(int i=array.length-1;i>0;i--){
            swap(array,0,i);
            heapAdjust(array,1,i);
        }
    }
    //生成大顶堆
    private void heapAdjust(int[] array,int i,int j){
        int temp = array[i-1];
        for(int a=i*2;a<=j;a*=2){
            if (a < j && array[a-1] < array[a]) {
                a++;
            }
            if(temp>array[a-1])
                break;
            array[i-1] = array[a-1];
            i= a;
        }
        array[i-1] = temp;
    }
    //归并排序
    private void mergeSort(int[] array){
        mSort(array,array,0,array.length-1);
    }

    private void mSort(int[] array1, int[] array2, int s, int t) {
        int m;
        int[] array3 = new int[10];
        if(s==t)
            array2[s] = array1[s];
        else {
            m=(s+t)/2;
            mSort(array1,array3,s,m);
            mSort(array1,array3,m+1,t);
            merge(array3,array2,s,m,t);
        }
    }

    private void merge(int[] array3, int[] array2, int s, int m, int t) {
        int j=0,k=0,l=0;
        for( j=m+1,k=s;s<=m&&j<=t;k++){
            if((array3[s]<array3[j])){
                array2[k]=array3[s++];

            }else array2[k]=array3[j++];
        }
        if(s<=m){
            for( l=0;l<=m-s;l++){
                array2[k]=array3[s+l];
            }
        }
        if(j<=t){
            for( l=0;l<=t-j;l++){
                array2[k]=array3[j+l];
            }
        }
    }
    //快速排序
    private void quickSort(int[] array){
        qSort(array,0,array.length-1);
    }

    private void qSort(int[] array, int low, int high) {
        int pivot=0;
        if(low<high){
            pivot=partition(array,low,high);
            qSort(array,low,pivot-1);
            qSort(array,pivot+1,high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivotKey=array[low];
        while (low<high){
            while (low<high&&array[high]>pivotKey)
                high--;
            swap(array,low,high);
            while (low<high&&array[low]<=pivotKey)
                low++;
            swap(array,low,high);
        }
        return low;
    }
    //基数排序
    private void radixSort(int[] array,int n) {
        int[][] array2 = new int[10][array.length];
        int[] tempArray = new int[10];
        int k=0;
        for(int x=10;x<=n;){
            for (int value : array) {
                int temp = value / (x / 10) % 10;
                array2[temp][tempArray[temp]] = value;
                tempArray[temp]++;
            }
            for(int i=0;i<10;i++){
                if(tempArray[i]!=0){
                    for(int j=0;j<tempArray[i];j++){
                        array[k] = array2[i][j];
                        k++;
                    }
                    tempArray[i]=0;
                }
            }
            k=0;
            x*=10;
        }
    }

}
