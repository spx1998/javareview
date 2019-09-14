package Algorithms.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution7 {
    public static void main(String[] args) {
    }
    public int reverse(int x) {
        char sign = String.valueOf(x).charAt(0);
        int flag=0;
        if(sign=='-')flag=1;
        char[] chars;
        if(flag==1){
           chars =String.valueOf(x).substring(1).toCharArray();
        }else {
            chars =String.valueOf(x).toCharArray();
        }

        for(int i=0;i<chars.length/2;i++){
            char c = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1]=c;
        }
        long l = Long.parseLong(String.valueOf(chars));
        if(flag==1)l=-l;
        if(l>Integer.MAX_VALUE||l<Integer.MIN_VALUE){
            return 0;
        }else return (int) l;
    }
}
