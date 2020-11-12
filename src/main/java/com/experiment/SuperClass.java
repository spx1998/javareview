package com.experiment;

public class SuperClass {

    String superName;

    public static void main(String[] args) {

        SuperClass superClass = new SubClass();
        SubClass subClass = (SubClass) superClass;
        System.out.println(subClass.superName);
        System.out.println(subClass.subName);
    }

}

class SubClass extends SuperClass {

    String subName;
}