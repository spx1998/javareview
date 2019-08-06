package Algorithms.JZoffer;

import java.util.HashMap;

public class Question27 {
    public static void main(String[] args) {
        Question27 question27 = new Question27();
        int[] ints = {1,3,5,3,4,2,7,1,3,3,3,3,3};
        System.out.println(question27.MoreThanHalfNum_Solution(ints));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i:array){
            if(!hashMap.containsKey(i)){
                hashMap.put(i,1);
                continue;
            }
            hashMap.put(i,hashMap.get(i)+1);
        }
        int temp =0;
        for(Integer i :hashMap.keySet()){
            if(hashMap.get(i)>array.length/2){
                temp = i;
                break;
            }
        }
        return temp;
    }
}