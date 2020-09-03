package com.experiment.genericprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        GenericClass<String> stringClass = new GenericClass<>("s");
        GenericClass<Integer> integerClass = new GenericClass<>(1);
        /**
         * GenericClass对象都是同一个类的实例，但data是不同类的实例。
         */
        System.out.println(stringClass.getClass().equals(integerClass.getClass()));//true
        System.out.println(stringClass.getData().getClass().equals(integerClass.getData().getClass()));//false
        System.out.println(Arrays.toString(stringClass.getClass().getTypeParameters()));//[T]
        /**
         * String和CharSequence之间存在继承关系，但下面的语句无法编译，两个泛型类之间不存在继承关系。因此使用<? extend T>使得两个容器之间存在类似继承的关系。
         */
//        List<CharSequence> charSequenceList = new ArrayList<String>();
        List<? extends CharSequence> list = new ArrayList<String>(Collections.singleton("1"));

//        不允许向其中写入数据
//        list.add(new String("s"));
//        list.add(new CharSequence() {...});

    }

}

