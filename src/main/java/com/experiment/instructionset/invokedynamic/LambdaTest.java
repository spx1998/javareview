package com.experiment.instructionset.invokedynamic;

/**
 * @author sunpengxiang
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaInterface innerClass = new LambdaInterface() {
            @Override
            public void test() {
                System.out.println("innerClass! ");
            }
        };
        LambdaInterface lambda = () -> System.out.println("lambda!");

        invokeLambda(innerClass);
        invokeLambda(lambda);

    }


    private static void invokeLambda(LambdaInterface lambda) {
        lambda.test();
    }

    interface LambdaInterface {
        void test();
    }
}
