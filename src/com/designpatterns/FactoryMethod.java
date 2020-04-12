package com.designpatterns;

/**
 * @author spx
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factory =new Factory2();
        factory.create();

    }
}

//product类在sample factory文件中
interface Factory{
    Product create();
}
class Factory1 implements Factory{

    @Override
    public Product create() {
        return new Product1();
    }
}
class Factory2 implements Factory{

    @Override
    public Product create() {
        return new Product2();
    }
}
