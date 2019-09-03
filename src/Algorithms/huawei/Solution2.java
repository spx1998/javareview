package Algorithms.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 牛客网华为三道编程题
 */
public class Solution2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0;i<num;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }

            for(Integer a:set){
                System.out.println(a);
            }
        }
    }
}
