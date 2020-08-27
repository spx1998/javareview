package com.algorithms.JZoffer;

public class Question12 {
    public static void main(String[] args) {
        Question12 question12 = new Question12();
        System.out.println(question12.Power(1.2, 15));
    }

    public double Power(double base, int exponent) {
        if (exponent==0) return 1;
        if(exponent==1) return base;
        double temp = base;
        if(exponent>0){
            for(int i=2;i<=exponent;i++){
                base*=temp;
            }
        }else {
            exponent = -exponent;
            for(int i=2;i<=exponent;i++){
                base*=temp;
            }
            base=1/base;
        }
        return base;
    }
}
