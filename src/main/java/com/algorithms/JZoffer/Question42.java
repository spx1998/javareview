package com.algorithms.JZoffer;

import java.util.ArrayList;

public class Question42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if(array.length<2) return new ArrayList<Integer>();
        int first = 0;
        int last = array.length-1;
        int num1 = array[0];
        int num2 = array[array.length-1];
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (first<last){
            if(num1+num2<sum) {
                first++;
                num1 = array[first];
            }
            if(num1+num2>sum) {
                last--;
                num2 = array[last];
            }
            if(num1+num2==sum){
                arrayList.add(num1);
                arrayList.add(num2);
                return arrayList;
            }
        }
        return new ArrayList<>();
    }
}