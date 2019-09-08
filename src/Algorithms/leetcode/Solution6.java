package Algorithms.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 */
public class Solution6 {
    public static void main(String[] args) {
        System.out.println(new Solution6().convert("a",1));
    }
    //LCIRETOESIIGEDHN
    public String convert(String s, int numRows) {
        if(s==null||s.equals(""))return "";
        if(numRows==1)return s;
        if(numRows>s.length()) return s;
        char[] chars = s.toCharArray();
        char[] newArray = new char[chars.length];
        int temp=0;
        for(int i=0;i<numRows;i++){
            int k=i;
            newArray[temp]=chars[k];
            temp++;
            while (k<chars.length){
                if(k!=k+(numRows-i-1)*2) {
                    k=k+(numRows-i-1)*2;
                    if(k<chars.length) {
                        newArray[temp] = chars[k];
                        temp++;
                    }
                }
                if(k!=k+i*2){
                    k=k+i*2;
                    if(k<chars.length) {
                        newArray[temp] = chars[k];
                        temp++;
                    }
                }
            }
        }
        return String.valueOf(newArray);
    }
}
