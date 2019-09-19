package Algorithms.practice.huawei2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 对一行给定的字符串进行反转输出，同时去除中间不满足条件的分隔符
 * 输入字符串：I am an 20-years out--standing @ * -stu- dent
 * 去除分割符并反转之后，输出字符串（子字符串以一个空格隔开）：dent stu standing out 20-years an am I
 * 分割符描述如下：
 * 1、除了字母、数字和 - 之外，其他的都是分割符，如输入字符串中的@ *等都属于分割符
 * 2、20-years中的'-' 表示的是连接符，即当‘-’两边都有字母、数字时，‘-’就属于连接符，否则属于分割符
 * 3、out--standing中的‘--’表示分割符，应该拆分为两个字字符串out 和 standing
 * 解决思路：用栈去实现，遍历输入字符串的字符：
 * 1、遇到字母和数字就入栈。
 * 2、遇到‘-’的时候就判断是分割符还是连接符，要是是分割符，就弹出所有栈元素，构成一个子字符串，否则就入栈
 * 3、遇到其他分割符，弹出所有栈元素，构成子字符串
 * 找到所有子字符串，就可以做反序输出处理
 */
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
