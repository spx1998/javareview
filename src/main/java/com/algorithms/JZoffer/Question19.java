package com.algorithms.JZoffer;

import java.util.ArrayList;

public class Question19 {
    public static void main(String[] args) {
        Question19 question19 = new Question19();
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] matrix = {{1,2,3,4}};
        System.out.println(question19.printMatrix(matrix));

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int y = matrix.length;//行数
        int x = matrix[0].length;//列数
        ArrayList<Integer> arrayList = new ArrayList<>();
        int times = x>y?y:x;
        times = times%2==0?times/2:times/2+1;
        while (times!=0){
            for(int i=matrix[0].length-x;i<x-1;i++){
                arrayList.add(matrix[matrix.length-y][i]);
            }
            for(int i = matrix.length-y;i<y-1;i++){
                arrayList.add(matrix[i][x-1]);
            }
            for (int i = x-1;i>matrix[0].length-x;i--){
                arrayList.add(matrix[y-1][i]);
                if(y-1==matrix.length-y)break;
            }
            for (int i = y-1;i>matrix.length-y;i--){
                arrayList.add(matrix[i][matrix[0].length-x]);
                if(x-1==matrix[0].length-x){
                    break;
                }
            }
            x--;
            y--;
            times--;
        }
        if(matrix[0].length==matrix.length&&matrix.length%2==1){
            arrayList.add(matrix[matrix.length/2][matrix.length/2]);
        }
        return arrayList;
    }
}
