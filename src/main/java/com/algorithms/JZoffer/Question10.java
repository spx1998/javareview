package com.algorithms.JZoffer;

public class Question10 {
    public static void main(String[] args) {
        Question10 question10 = new Question10();
        System.out.println(question10.RectCover(10));
    }
    public int RectCover(int target) {

        if(target<3)return target;
        int a=1;
        int b=2;
        int temp=0;
        for(int i=3;i<=target;i++){
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }
}
