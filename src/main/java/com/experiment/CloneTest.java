package com.experiment;

/**
 * 输出：
 * i am a clone test!
 * false
 * true
 *
 * 1 clone()创建新对象不会执行构造函数
 * 2 浅拷贝
 */
public class CloneTest implements Cloneable {
    Integer temp = 1;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest();
        CloneTest clone = (CloneTest) cloneTest.clone();
        System.out.println(clone == cloneTest); //false
        System.out.println(clone.temp == cloneTest.temp); //true
    }

    CloneTest() {
        System.out.println("i am a clone test!");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void addTemp(int i) {
        temp += i;
    }
}
