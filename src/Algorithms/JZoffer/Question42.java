package Algorithms.JZoffer;

public class Question42 {
    public String LeftRotateString(String str, int n) {
        if(n>str.length())return "";
        char[] chars = str.toCharArray();
        String left = String.copyValueOf(chars,0,n);
        String right = String.copyValueOf(chars,n,str.length()-n);
        return right+left;
    }
}