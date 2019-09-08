package Algorithms.leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * ac
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals(""))return 0;
        int max = 0;
        int temp=0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            for (int j=i-temp;j<i;j++) {
                if(chars[i]==chars[j]){
                    temp = i-j-1;
                    break;
                }
            }
            temp++;
            if(temp>max)
                max=temp;
        }
        return max;

    }
}
