package com.algorithms.JZoffer;

import java.util.Arrays;
import java.util.HashMap;

public class Question32 {
    public static void main(String[] args) {
        Question32 question32 = new Question32();
        int[] ints = {1,11,111};
        System.out.println(question32.PrintMinNumber(ints));
    }
    public String PrintMinNumber(int[] numbers) {
        if(numbers==null||numbers.length==0) return "";
        int digit =0;
        for (int value : numbers) {
            int x = String.valueOf(value).length();
            if (x > digit)
                digit = x;
        }
        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int number : numbers) {
            StringBuilder temp = new StringBuilder(String.valueOf(number));
            while (temp.length() != digit) {
                temp.append(temp.charAt(temp.length() - 1));
            }
            if(hashMap.get(Integer.parseInt(String.valueOf(temp)))==null)
                hashMap.put(Integer.parseInt(String.valueOf(temp)), String.valueOf(number));
            else {
                hashMap.put(Integer.parseInt(String.valueOf(temp)),hashMap.get(Integer.parseInt(String.valueOf(temp)))+ number);
            }
        }
        int[] keys = new int[hashMap.size()];
        int i=0;
        for(Integer integer:hashMap.keySet()){
            keys[i++] =integer;
        }
        Arrays.sort(keys);
        String str = "";
        for(int key:keys){
            str +=hashMap.get(key);
        }
        return str;
    }
}