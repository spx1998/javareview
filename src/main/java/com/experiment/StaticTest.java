package com.experiment;

/**
 * 运行：
 * StaticTest test1 = new StaticTest();
 * StaticTest test2 = new StaticTest();
 * 输出顺序：
 * 加载静态成员变量!
 * 静态代码块！
 * 加载普通成员变量！
 * 构造代码块！
 * 构造方法！
 * 加载普通成员变量！
 * 构造代码块！
 * 构造方法！
 * <p>
 * 如果不进行new StaticTest()，则输出：
 * 加载静态成员变量!
 * 静态代码块！
 * <p>
 * 可以见得：
 * 1 静态变量和静态代码块在类加载时记载或执行一次且仅一次；
 * 2 先加载变量，再执行构造代码块，最后执行构造方法；对于类来说，先加载静态变量，再执行静态代码块。
 */
public class StaticTest {
    static String s = setStaticString();
    String ss = setString();

    private String setString() {
        System.out.println("加载普通成员变量！");
        return "str";
    }

    static {
        System.out.println("静态代码块！");
    }

    {
        System.out.println("构造代码块！");
    }

    static private String setStaticString() {
        System.out.println("加载静态成员变量!");
        return "str";
    }

    private StaticTest() {
        System.out.println("构造方法！");
    }

    public static void main(String[] args) {
        StaticTest test1 = new StaticTest();
        StaticTest test2 = new StaticTest();
    }
}
