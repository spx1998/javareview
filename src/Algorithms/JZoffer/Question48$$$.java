package Algorithms.JZoffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 13+11 = ？;
 *   13 的二进制      1 1 0 1                     -----a        13
 *   11 的二进制      1 0 1 1                     -----b        11

 *    (a&b)<<1  ->  1 0 0 1 0   -----d         18
 *     a^b  ->     0 1 1 0      -----e          6
 *
 *      (d&e)<<1  ->  0 0 1 0 0 ------f         4
 *      d^e  ->  1 0 1 0 0       -----g        20
 *
 *      (f&g)  <<1  ->  0 1 0 0 0------h        8
 *      f^g  ->  1 0 0 0 0      ------i        16
 *
 *      (h&i)  <<1  ->  0 0 0 0 0  ------h      0   --------退出循环
 *      h^i  ->  1 1 0 0 0        ------i      24
 */
public class Question48$$$ {
    public static void main(String[] args) {
        Question48$$$ question47 = new Question48$$$();
        System.out.println(question47.Add(1,2));
    }

    public int Add(int num1, int num2) {
        while (num2!=0){
            int temp=num1^num2;
            num2= (num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}