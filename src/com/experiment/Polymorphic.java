package com.experiment;

public class Polymorphic {
    public static void main(String[] args) {
        Person person = new Man();
        person.say();//i am a man!
//        Man man = new Person(); 错误
    }
}

class Person{
    public void say(){
        System.out.println("i am a person!");
    }
}
class Man extends Person{
    @Override
    public  void say(){
        System.out.println("i am a man!");
    }
}
class Woman extends Person{
    @Override
    public  void say(){
        System.out.println("i am a Woman!");
    }
}