package com.experiment;

public class StringTest {

    public static void main(String[] args) {
        /**
         * intern()方法测试
         */
        String s1 = new String("str");
        String s2 = new String("str");
        String ss = "str";
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s1 == s2);//false
        System.out.println(s1 == ss);//false
        System.out.println(s1 == s3);//false
        System.out.println(ss == s3);//true
        System.out.println(s3 == s4);//true


        String str = new String("hello");
        String str2 = str.intern();
        String str3 = new String("wor") + new String("ld");
        String str4 = str3.intern();
        System.out.println(str == str2);//false
        System.out.println(str3 == str4);//true
        System.out.println("==========+测试============");
        String ss1 = "hello";
        String ss2 = "world";
        String str5 = ss1 + ss2;
        String str6 = "hello" + "world";
        String str7 = "helloworld";
        System.out.println(str5 == str6);//false
        System.out.println(str6 == str7);//true

        /**
         * charAt()方法测试
         */
        System.out.println("==========charAt============");
        System.out.println("abc".charAt(0));
//        System.out.println("abc".charAt(-1));
//        System.out.println("abc".charAt(3));

        /**
         * valueOf()方法测试
         */
        Object o = null;
        System.out.println("============valueOf========");
        System.out.println(String.valueOf(o));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(false));
//        System.out.println(String.valueOf(null));

        /**
         * compareTo()方法测试。
         */
        System.out.println("============compareTo========");
        System.out.println("a".compareTo("b"));//-1
        System.out.println("ab".compareTo("ac"));//-1
        System.out.println("cd".compareTo("ae"));//2
        System.out.println("ab".compareTo(new String("ab")));//0
        System.out.println("abc".compareTo("abcde"));//-2
        /**
         * 空字符串的hash码
         */
        System.out.println("============hashCode========");
        System.out.println("".hashCode());//0
    }
}
