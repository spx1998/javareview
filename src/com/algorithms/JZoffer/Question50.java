package com.algorithms.JZoffer;

import java.util.HashSet;

public class Question50 {
    public static void main(String[] args) {
    }
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers==null)return false;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i:numbers){
            if(!hashSet.add(i)){
                duplication[0]=i;
                return true;
            }
        }
        return false;
    }
}