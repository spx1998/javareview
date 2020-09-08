package com.experiment.innerclass;

public class Test {
    class Bean1 {

    }

    static class Bean2 {

    }

    public static void main(String[] args) {
        Test test = new Test();
        Bean1 bean1 = test.new Bean1();
        Bean2 bean2 = new Test.Bean2();
        OutClass outClass = new OutClass();
        OutClass.InnerClass innerClass = outClass.new InnerClass();
        OutClass.StaticInnerClass staticInnerClass = new OutClass.StaticInnerClass();
    }
}
