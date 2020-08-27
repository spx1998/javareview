package com.algorithms.JZoffer;

import java.util.*;

public class Question45 {
    public static void main(String[] args) {
        Question45 question45 = new Question45();
        question45.isContinuous(new int[]{0,3,2,6,4});
    }
    public boolean isContinuous(int[] numbers) {
        int zeroCount =0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i:numbers){
            if(i==0)zeroCount++;
            else   treeSet.add(i);
        }
        if(treeSet.size()+zeroCount<5)return false;
        int max =0;
        int min=14;
        for (Integer integer : treeSet) {
            int i =  integer;
            if (i > max) max = i;
            if (i < min) min = i;
        }
        return max - min <= 4;
    }
}