package com.experiment;

/**
 * 父类不可强制型转为子类，除非它本身就是一个子类型转得到的。
 *
 * @author sunpengxiang
 */
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