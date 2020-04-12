package com.algorithms.JZoffer;

public class Question2 {
    public static void main(String[] args) {
        Question2 question2 =new Question2();
        System.out.println(question2.replaceSpace(new StringBuffer("1 3 a")));
    }

    private String replaceSpace(StringBuffer str) {
       int length = str.length();
       int count = 0;
       int[] temp = new int[length];
       for(int i=0;i<length;i++){
           if(str.charAt(i)==' '){
               count++;
               temp[i]=1;
           }
       }
       char[] chars = new char[length+2*count];
       int num = 0 ;
       for (int i=0;i<length;i++){
           if(temp[i]!=1){
               chars[num]=str.charAt(i);
           }else {
               chars[num++]='%';
               chars[num++]='2';
               chars[num]='0';
           }
           num++;

       }
       StringBuffer sb= new StringBuffer();
        for (char c:chars) {
            sb.append(c);
        }
       return sb.toString();
    }
}
