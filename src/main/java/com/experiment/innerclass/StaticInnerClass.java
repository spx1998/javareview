package com.experiment.innerclass;

public class StaticInnerClass {

    public static void main(String[] args) {
        new StaticInnerClass().test();
    }

    public void test() {
        InnerClass innerClass = new InnerClass();
        innerClass.setI(5);
        InnerClass innerClass2 = new InnerClass();
        System.out.println(innerClass.getI());
        System.out.println(innerClass2.getI());

    }

    static class InnerClass {
        private int i = 1;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
