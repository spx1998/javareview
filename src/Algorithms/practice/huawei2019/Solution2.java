package Algorithms.practice.huawei2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine();
        scanner.close();
        char[] chars = str.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        String s="";
        for(int i=0;i<chars.length;i++){
            if(((int)chars[i]>=48&&(int)chars[i]<=57)||((int)chars[i]>=65&&(int)chars[i]<=90)||((int)chars[i]>=97&&(int)chars[i]<=122)){
                s += chars[i];
            }
            else if(chars[i]=='-'){
                if(i==0||chars[i-1]!='-'){
                    s += chars[i];
                }
                else {
                    if(!s.equals(""))
                    strings.add(s);
                    s="";
                }
            }else {
                if(!s.equals(""))
                    strings.add(s);
                s="";
            }
        }
        if(!s.equals(""))
            strings.add(s);
        for(int i=strings.size()-1;i>=0;i--){
            if(strings.get(i).charAt(0)=='-'){
                strings.set(i,strings.get(i).substring(1));
            }
            if(strings.get(i).charAt(strings.get(i).length()-1)=='-'){
                strings.set(i,strings.get(i).substring(0,strings.get(i).length()-1));
            }
            System.out.print(strings.get(i));
            if(i!=0){
                System.out.print(" ");
            }
        }
    }
}
