package Algorithms.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        char[] chars =s.toCharArray();
        ArrayList<Integer> arrayList =new ArrayList<>();
        int num =0;
        int length=0;
        for(int i=0;i<chars.length;i++){
            if(i==chars.length-1){
                if(chars[i]==chars[i-1]){
                    length++;
                    arrayList.add(length);
                    num++;
                }else {
                    arrayList.add(length);
                    arrayList.add(1);
                    num+=2;
                }
                continue;
            }
            if(i==0){
                length++;
                continue;
            }
            if(chars[i]==chars[i-1]){
                length++;
            }else {
                num++;
                arrayList.add(length);
                length=1;
            }
        }
        int sum=0;
        for(int i:arrayList){
            sum+=i;
        }
        System.out.printf("%.2f",(double)sum/num);
    }
}
