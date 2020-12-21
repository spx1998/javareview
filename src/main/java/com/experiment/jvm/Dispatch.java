package com.experiment.jvm;

import java.io.IOException;

/**
 * @author sunpengxiang
 */
public class Dispatch {
    public static void main(String[] args) throws IOException {
        overloadStaticMethod("s");
        overloadStaticMethod(1);
        Dispatch dispatch = new Dispatch();
        dispatch.overloadMethod("s");
        dispatch.overloadMethod("s");
        dispatch.overloadMethod(1);
        Dispatch subDispatch = new SubDispatch();
        System.out.println(dispatch.overrideMethod(5));
        System.out.println(subDispatch.overrideMethod(5));
        System.out.println(subDispatch.num);// 3 ，通过静态类型访问字段
//        subDispatch.test()
    }

    static String overloadStaticMethod(String s) {
        System.out.println(s);
        return s;
    }

    static int overloadStaticMethod(Integer i) {
        System.out.println(i);
        return i;
    }

    String overloadMethod(String s) {
        System.out.println(s);
        return s;
    }

    int overloadMethod(Integer i) {
        System.out.println(i);
        return i;
    }

    int overrideMethod(Integer i){
        return i * 10;
    }

    int num = 3;


    static class SubDispatch extends Dispatch {
        int num = 5;


        @Override
        int overrideMethod(Integer i) {
            return super.overrideMethod(i) * 10;
        }

        void test(){

        }
    }
}
