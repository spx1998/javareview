package com.experiment.jvm;

/**
 * try-catch-finally实验，字节码在同目录下
 */
public class TryTest {
    public static void main(String[] args) {
        TryTest tryTest = new TryTest();
        System.out.println( tryTest.takeATry());
    }

    /**
     * 见byte1 结果：10
     * 10先被store_1存到本地变量数组中的第一个位置，在finally中设置i=20时，10先被取出并存到了第二个位置，20被存到第一个位置。最后返回的是第二个位置中的10.
     */
/*    private int takeATry() {
        int i ;
        try {
            i = 10;
            return i;
        }catch (Exception e){
            throw e;
        }finally {
            i = 20;
        }
    }*/

    /**
     * 见byte2 结果：10
     * 与第一种情况类似，只不过istore指令变成了astore指令
     */
   /* private Integer takeATry() {
        Integer i ;
        try {
            i = 10;
            return i;
        }catch (Exception e){
            throw e;
        }finally {
            i = 20;
        }
    }*/

    /**
     * 见byte3 结果：10
     * 先执行完return后的语句，存储到局部变量array，然后执行finally中的代码，finally中的结果用不到，会被pop出栈。最后从局部变量数组中取得之前set进去的值返回。
     */
    /*private int takeATry() {
        Node node = new Node();
        try {
            return node.setI(10).getI();
        }finally {
            node.setI(20);
        }
    }*/

    static class Node {
        private int i = 1;

        Node setI(int i) {
            this.i = i;
            return this;
        }

        int getI(){
            return i;
        }
    }

    /**
     * 见byte4 结果：200
     * finally中的return会把try中的覆盖掉。
     */
    private int takeATry() {
        try {
            int i =100;
            return i;
        }finally {
            int j =200;
            return j;
        }
    }

}
