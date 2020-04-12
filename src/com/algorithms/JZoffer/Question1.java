package com.algorithms.JZoffer;

public class Question1 {
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(question1.find(1,array));
    }
    private boolean find(int target,int[][]array){

        for (int[] ints : array) {
            int low = 0;
            int high = ints.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > ints[mid])
                    low = mid + 1;
                else if (target < ints[mid])
                    high = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }
}