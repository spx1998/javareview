package Algorithms.practice.youzan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        System.out.println(lack(list));
    }
    private static Integer lack(List<Integer> list){
        Collections.sort(list);
        int sum = 0;
        for(int i=0;i<=list.get(list.size()-1);i++){
            sum += i;
        }
        for(int i:list){
            sum -= i;
        }
        return sum;
    }
}
