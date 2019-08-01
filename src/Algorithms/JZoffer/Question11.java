package Algorithms.JZoffer;

public class Question11 {
    public static void main(String[] args) {
        Question11 question11 = new Question11();
        System.out.println(question11.NumberOf1(10));

    }

    public int NumberOf1(int n) {
//        Java自带的函数
//        return Integer.bitCount(n);
        int i ;
        for ( i=0;n!=0;i++){
            n = n&(n-1);

        }
        return i ;
    }
}
