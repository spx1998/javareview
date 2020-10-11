package com.experiment;

/**
 * 变长参数
 *
 * @author sunpengxiang
 */
public class VarArgsTest {
    /**
     * 只有第一个print ：
     * 输出 b
     * 有两个print：
     * 输出 a b
     * --在定长和变长参数的方法都可以选择时优先选择定长的方法。
     * --加上第三个print 编译不能通过，因为编译器无法对第一个方法和第三个方法作出选择。
     * --第四个print也不能通过编译，变长参数只能作为方法的最后一个参数。
     * --第5和第6个也是不能同时存在的，因为变长参数本身是一个语法糖，它在底层是通过数组实现的。
     */
    public static void main(String[] args) {
        VarArgsTest varArgsTest = new VarArgsTest();
        varArgsTest.print("");
        varArgsTest.print("a");
        varArgsTest.print("a", "b");
        varArgsTest.print("a", "b", "c");
        varArgsTest.print(new String[]{"a"});
    }

    /**
     * 1
     */
    public void print(String s, String... ss) {
        for (String str : ss) {
            System.out.println(str);
        }
    }

    /**
     * 2
     */
    public void print(String s1, String s2) {
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * 3
     */
/*    public void print(String... strings) {

    }*/

    /**
     * 4
     */
    /*public void print(String... strings, Integer i) {

     }

     */

    /**
     * 5
     */
    public void print(String[] strings) {

    }

    /**
     * 6
     */
    /*public void print(String...strings){

    }*/
}
