package Algorithms.leetcode_DP;

/**
 * 最长回文子字符串问题
 * 反转字符串方法
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        String s = new Solution5().longestPalindrome("babad");
    }
    public String longestPalindrome(String s) {
        if(s==null||s.equals(""))return s;
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] arr=new int[s.length()][s.length()];
        int maxlen=0;
        int lastIndex=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        arr[i][j]=1;
                    }else {
                        arr[i][j]=arr[i-1][j-1]+1;
                    }
                    if (arr[i][j] > maxlen) {
                        int beforeRev = s.length() - 1 - j;
                        if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                            maxlen = arr[i][j];
                            lastIndex = i;
                        }
                    }
                }
            }
        }
        return s.substring(lastIndex-maxlen+1,lastIndex+1);
    }
}
