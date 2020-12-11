package com.experiment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author sunpengxiang
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaInterface innerClass = new LambdaInterface() {
            @Override
            public int test() {
                return 123;
            }
        };
        LambdaInterface lambda = () -> 456;

        invokeLambda(innerClass);
        invokeLambda(lambda);

        System.out.println(innerClass.test());
        System.out.println(lambda.test());
    }


    private static void invokeLambda(LambdaInterface lambda) {
        System.out.println(lambda.test());
    }

    interface LambdaInterface {
        int test();
    }
}
