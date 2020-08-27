package com.algorithms.JZoffer;

public class Question48 {
    public static void main(String[] args) {
        Question48 question48 = new Question48();
        System.out.println(question48.StrToInt("1a23"));
    }
    public int StrToInt(String str) {
        if(str.trim().equals(""))return 0;
        char[] chars = str.toCharArray();
        int flag =0;
        if(chars[0]=='-')flag=1;
        if(chars[0]=='+')flag=2;
        int i;
        int num=0;
        if(flag==0)i=0;
        else i=1;
        for(;i<chars.length;i++){
            if(chars[i]-48<0||chars[i]-48>=10)return 0;
            num = num*10+chars[i]-48;
        }
        if(flag==1) num=-num;
        return num;
    }
}