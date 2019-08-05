package experiment;

public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String ("aaa");
        String ss = "aaa";
        System.out.println(s1==s2);//false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s2==s3);//false
        System.out.println(s1==s4);//false
        System.out.println(s3==s4);//true
        System.out.println(ss==s1);//false
        System.out.println(ss==s3);//true


    }
}
