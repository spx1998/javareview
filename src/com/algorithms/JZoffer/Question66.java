package com.algorithms.JZoffer;

public class Question66 {
    public static void main(String[] args) {
        Question66 question66 =new Question66();
        question66.movingCount(4,10,10);
    }
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
    return count(0, 0, rows, cols, flag, threshold);
    }
    private int count(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return count(i - 1, j, rows, cols, flag, threshold)+
                count(i + 1, j, rows, cols, flag, threshold)+
                count(i, j - 1, rows, cols, flag, threshold)+
                count(i, j + 1, rows, cols, flag, threshold)+1;
    }
    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;

    }
}
