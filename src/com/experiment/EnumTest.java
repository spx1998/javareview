package com.experiment;

public class EnumTest {
    public static void main(String[] args) {
        Color.RED.say();
    }
}
enum Color{
    RED("红",1),YELLOW("黄",2);

    Color(String color, int i) {
    }
    void say(){
        System.out.println("i am "+this.name());
    }
}
