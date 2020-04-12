package com.algorithms.JZoffer;

public class Question6 {
    public static void main(String[] args) {
        Question6 question6 = new Question6();
        int[] array = {4,4,5,5,1,2,3};
        System.out.println(question6.minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        for(int i=0;i<array.length-2;i++){
            if(array[i]>array[i+1])
                return array[i+1];
        }
        return array[0];
    }
}
