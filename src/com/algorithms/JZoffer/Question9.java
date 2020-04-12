package com.algorithms.JZoffer;

public class Question9 {
    public static void main(String[] args) {
        Question9 question9 = new Question9();
        System.out.println(question9.JumpFloorII(4));
    }

    public int JumpFloorII(int target) {
         if(target==1||target==2)
             return target;
         int[] array = new int[target+1];
         array[0]=1;
         array[1]=1;
         array[2]=2;
         for(int i=3;i<=target;i++){
             for(int j=0;j<i;j++){
                 array[i]+=array[j];
             }
         }
         return array[target];
    }
}