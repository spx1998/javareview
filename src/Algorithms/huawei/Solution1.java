package Algorithms.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 牛客网华为三道编程题
 */
public class Solution1 {

   public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            if(n==0)break;
            else arrayList.add(n);
            if(arrayList.size()==10)break;
        }
        scanner.close();
        for(int i:arrayList){
            int count =0;
            count = i/2;
            System.out.println(count);
        }
    }


}
