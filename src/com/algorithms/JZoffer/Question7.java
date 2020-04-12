package com.algorithms.JZoffer;

public class Question7 {
    public static void main(String[] args) {
        Question7 question7 =new Question7();
        System.out.println(question7.Fibonacci(5));
    }
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            if(i==0||i==1)
                array[i]=1;
            else array[i]=array[i-2]+array[i-1];
        }
        return array[n-1];
    }
}
