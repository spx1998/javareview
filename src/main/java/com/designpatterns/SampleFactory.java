package com.designpatterns;

/**
 * @author spx
 * 简单工厂 严格来说 并不是一种设计模式
 */
public class SampleFactory {
    public Product createProduct(int num){
        if(num==1)
            return new Product1();
        else if(num==2)
            return new Product2();
        else return new DefaultProduct();
    }
    public static void main(String[] args) {
        SampleFactory sampleFactory =new SampleFactory();
        Product product = sampleFactory.createProduct(1);
    }
}

interface Product{

}
class Product1 implements Product{
    public Product1() {
        System.out.println("new product1");
    }
}
class Product2 implements Product{
    public Product2() {
        System.out.println("new product2");
    }
}
class DefaultProduct implements Product{
    public DefaultProduct() {
        System.out.println("new defaultProduct");
    }
}