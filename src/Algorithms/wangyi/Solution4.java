package Algorithms.wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 超时了
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int l=scanner.nextInt();
        int[] parent = new int[n-1];
        HashMap<Integer, List<Integer>> hashMap =new HashMap<>();//每个城市 相连城市列表
        for(int i=0;i<n-1;i++){
            parent[i]= scanner.nextInt();
            hashMap.computeIfAbsent(i+1, k -> new ArrayList<>());
            hashMap.get(i+1).add(parent[i]);
            hashMap.computeIfAbsent(parent[i], k -> new ArrayList<>());
            hashMap.get(parent[i]).add(i+1);
        }
        scanner.close();
        HashMap<Integer,Boolean> booleanHashMap = new HashMap<>();
        booleanHashMap.put(0,true);
        int count=1;
        int max = move(0,l,hashMap,booleanHashMap,count);
        System.out.println(max);
    }

    private static int move(int thisCity, int l, HashMap<Integer, List<Integer>> hashMap, HashMap<Integer, Boolean> booleanHashMap, int count) {
        if(booleanHashMap.get(thisCity)==null) {
            booleanHashMap.put(thisCity, true);
            count++;
        }
        if(l==0)return count;
        int max=0;
        for(int city:hashMap.get(thisCity)){
            max =Math.max(max,move(city,l-1,hashMap,new HashMap<>(booleanHashMap), count));
        }
        return max;
    }
}
