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
        String str =new String("计算机");
        String str2 = str.intern();
        System.out.println(str==str2);//false str.intern()返回的是  "计算机"  在常量池加入的这一字符串。
        String str3 = new String("电")+new String("脑");
        String str4 = str3.intern();
        System.out.println(str3==str4);//true
        String str5 = str+str3;
        String str6 = "计算机"+"电脑";
        String str7 = "计算机电脑";
        System.out.println(str5==str6);//false
        System.out.println(str6==str7);//true
    }
}
