package com.experiment.instructionset.instanceOf;

/**
 * @author sunpengxiang
 *
 */
public class InstanceofTest {
    public static void main(String[] args) {
        Number i = new Integer(1);
        System.out.println(i instanceof Integer);
        System.out.println(i instanceof Number);
    }
}
