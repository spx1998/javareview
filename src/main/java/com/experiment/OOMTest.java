package com.experiment;

/**
 * @author sunpengxiang
 */
public class OOMTest {
    public static void main(String[] args) {
        int[] ints = new int[1];
        System.out.println(ints);
        ints[0] = 100;
        try {
            ints = new int[Integer.MAX_VALUE];
        } finally {
            System.out.println(ints);
        }
    }
}
