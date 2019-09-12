package Algorithms.practice.huawei2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        int r ;
        int flag=0;
        String s="";
        for(int i=0;i<chars.length;i++){
            if(flag==0){
                if((int)chars[i]>=48&&(int)chars[i]<=57){
                    s += chars[i];
                }
                if(chars[i]==','){
                    aList.add(Integer.parseInt(s));
                    s="";
                }
                if(chars[i]=='B'){
                    flag++;continue;
                }
            }
            if(flag==1){
                if((int)chars[i]>=48&&(int)chars[i]<=57){
                    s += chars[i];
                }
                if(chars[i]==','){
                    bList.add(Integer.parseInt(s));
                    s="";
                }
//                修改之处1
                if(chars[i]=='R'){
                    flag++;
                    continue;
                }
            }
            if(flag==2){
                if((int)chars[i]>=48&&(int)chars[i]<=57){
                    s += chars[i];
                }
            }
        }
        r = Integer.parseInt(s);
        for(Integer i:aList){
            flag=0;
            int temp=0;
            for(Integer j:bList){
                if(temp==0&&j>i){
                    temp=j;
                }
                if(j>i&&j-i<=r){
                    System.out.print("("+i+","+j+")");
                    flag=1;
                }
            }
//            修改之处2
            if(flag==0&&temp!=0){
                System.out.print("("+i+","+temp+")");
            }
        }
    }
}
