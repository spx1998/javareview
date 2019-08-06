package experiment;

public class StaticTest {
    static String s = setStaticString();
    String ss= setString();

    private String setString() {
        System.out.println("加载普通成员变量！");
        return "str";
    }

    static {
        System.out.println("静态代码块！");
    }
    {
        System.out.println("构造代码块！");
    }
    static private String setStaticString(){
        System.out.println("加载静态成员变量!");
        return "str";
    }
    private StaticTest(){
        System.out.println("构造方法！");
    }

    public static void main(String[] args) {
        StaticTest test1 = new StaticTest();
        StaticTest test2 = new StaticTest();
    }
}
