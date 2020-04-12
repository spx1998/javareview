package com.algorithms.JZoffer;

import java.util.Arrays;

public class Question13 {
    public static void main(String[] args) {
        Question13 question13 = new Question13();
        int[] array = {1,2,3,4,5,6};
        question13.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    public void reOrderArray(int [] array) {
        int[] pre = new int[array.length];
        int[] after = new int[array.length];
        int j=0,k=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                pre[j++]=array[i];
            }else after[k++] = array[i];
        }
        for(int i=0;i<j;i++){
            array[i]=pre[i];
        }
        for (int i=0;i<k;i++){
            array[j+i] = after[i];
        }
    }
    }
