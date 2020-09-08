package com.experiment;

import java.util.ArrayList;
import java.util.List;

/**
 * 反编译结果：foreach是通过iterator实现的。
 * public static void main(String[] args) {
 *     List<String> list = new ArrayList();
 *     list.add("a");
 *     list.add("b");
 *     list.add("c");
 *     Iterator var2 = list.iterator();
 *
 *     while(var2.hasNext()) {
 *       String s = (String)var2.next();
 *       System.out.println(s);
 *     }
 *
 *   }
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
