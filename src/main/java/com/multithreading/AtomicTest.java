package com.multithreading;

import java.util.concurrent.atomic.*;

public class AtomicTest {
     volatile  int score =0;
    public static void main(String[] args) {

        AtomicInteger atomicInteger =new AtomicInteger();//原子整数
        atomicInteger.set(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        AtomicReference<Integer> reference = new AtomicReference<>(1); //原子对象，无法记录过程
        reference.set(100);
        AtomicStampedReference<Long> stampedReference = new AtomicStampedReference<>(5L,0);// 带时间戳的原子对象

        AtomicIntegerArray integerArray =new AtomicIntegerArray(5);//原子整数数组
        integerArray.set(1,4);
        AtomicIntegerFieldUpdater<AtomicTest> atomicTestAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicTest.class,"score");

    }
}
