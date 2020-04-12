package com.designpatterns;

/**
 * @author spx
 * 抽象工厂模式
 * 在这里举一个例子： farmA、farmB、farmC是三个农场 他们都养殖猪和牛 并且分别养殖的abc三个品种不同的猪/牛。
 */
public class AbstarctFactory {
    public static void main(String[] args) {
        Farm farm = new FarmC();
        farm.createPig();
        farm.createCattle();
    }
}
interface Farm{
    Pig createPig();
    Cattle createCattle();
}
class FarmA implements Farm{

    @Override
    public Pig createPig() {
        return new PigA();
    }

    @Override
    public Cattle createCattle() {
        return new CattleA();
    }
}
class FarmB implements Farm{

    @Override
    public Pig createPig() {
        return new PigB();
    }

    @Override
    public Cattle createCattle() {
        return new CattleB();
    }
}
class FarmC implements Farm{

    @Override
    public Pig createPig() {
        return new PigC();
    }

    @Override
    public Cattle createCattle() {
        return new CattleC();
    }
}
interface Pig{}
interface Cattle{}
class PigA implements Pig{
    {
        System.out.println("i am a new PigA!");
    }
}
class PigB implements Pig{
    {
        System.out.println("i am a new PigB!");
    }
}class PigC implements Pig{
    {
        System.out.println("i am a new PigC!");
    }
}
class CattleA implements Cattle{
    {
        System.out.println("i am a new CattleA!");
    }
}
class CattleB implements Cattle{
    {
        System.out.println("i am a new CattleB!");
    }
}class CattleC implements Cattle{
    {
        System.out.println("i am a new CattleC!");
    }
}
