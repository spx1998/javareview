package experiment;

public class AutomaticPackingTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer m = 150;
        Integer n =171;
        int s=321;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c==d);//true 3在缓存池中
        System.out.println(e==f);//false 321 不在缓存池中
        System.out.println((a+b)==c);//true ==遇到算数运算符 则自动拆箱为int 3==3
        System.out.println(c.equals(a+b));//true  equals()不处理数据转型 但此处 a+b本来就是int型
        System.out.println(g==(a+b));//true ==遇到算数运算符 则自动拆箱为long 3L==3L
        System.out.println((g.equals(a+b)));//false equals()不处理数据转型
        System.out.println((n+m)==e);//true  ==遇到算数运算符 则自动拆箱为int 321==321
    }
}
