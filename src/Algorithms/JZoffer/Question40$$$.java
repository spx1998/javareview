package Algorithms.JZoffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//异或的解法更佳
public class Question40$$$ {
    public static void main(String[] args) {
        Question40$$$ question40$$$ = new Question40$$$();
        question40$$$.FindNumsAppearOnce2(new int[]{1,1,2,2,3,4}, new int[]{0}, new int[]{0});
    }
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : array) {
            if (hashMap.get(i) == null) {
                hashMap.put(i, 1);
            } else hashMap.put(i, 2);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) arrayList.add(key);
        }
        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }
    //两次异或解法
    public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        int temp =array[0];
        for(int i=1;i<array.length;i++){
            temp ^=array[i];
        }
        int count =0;
        while ((temp%2)!=1){
            temp =temp>>1;
            count++;
        }
        for (int value : array) {
            if ((value >> count) % 2 == 1) {
                num1[0] ^= value;
            }
            if ((value >> count) % 2 == 0) {
                num2[0] ^= value;
            }
        }
    }
}