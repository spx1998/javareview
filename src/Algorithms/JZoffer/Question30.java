package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question30 {
    public static void main(String[] args) {

    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int maxNum = array[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                int temp = 0;
                for (int j = i; j < array.length; j++) {
                    temp += array[j];
                    if (array[j] > 0) {
                        arrayList.add(temp);
                    }
                }
            }
            if (array[i] > maxNum)
                maxNum = array[i];
        }
        if (arrayList.size() == 0) {
            return maxNum;
        } else {
            maxNum = arrayList.get(0);
            for (Integer integer : arrayList) {
                if (integer > maxNum) {
                    maxNum = integer;
                }
            }
        }
        return maxNum;
    }

    //动态规划解法
    public int FindGreatestSumOfSubArray2(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
