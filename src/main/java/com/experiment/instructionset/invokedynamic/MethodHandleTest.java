package com.experiment.instructionset.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author sunpengxiang
 */
public class MethodHandleTest {
    public static void main(String[] args) throws Throwable {
        MethodHandleTest methodHandleTest = new MethodHandleTest();

        MethodType mt = MethodType.methodType(void.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(methodHandleTest.getClass(), "test", mt);
        mh.invoke(methodHandleTest);
    }

    void test() {
        System.out.println("methodHandle test");
    }
}
