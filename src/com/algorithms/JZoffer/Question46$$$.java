package com.algorithms.JZoffer;
//&&与递归 佛辣
public class Question46$$$ {
    public static void main(String[] args) {
        Question46$$$ question46$$$ = new Question46$$$();
        System.out.println(question46$$$.Sum_Solution(1));
    }
    public int Sum_Solution(int n) {
        int temp=n;
        boolean b = (temp>0)&&(temp+=Sum_Solution(n-1))>0;
        return temp;
    }
}