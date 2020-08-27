package com.algorithms.JZoffer;

public class Question8 {
    public static void main(String[] args) {
        Question8 question8 = new Question8();
        System.out.println(question8.JumpFloor(5));
    }
    public int JumpFloor(int target) {
        int a=1;
        int b=2;
        int temp = 0;
        if(target<3)
            return target;
        for(int i=3;i<=target;i++){
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
