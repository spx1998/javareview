package com.algorithms.classical;

/**
 * 马拉车求解回文子串问题。
 * 1) 将长度为奇数或者偶数的字符串都转换成长度为奇数的字符串方便统一处理；
 * 2) P[i]树组记录以i为中心的最长的回文子串的臂长。【回文串s的臂长定义 s.length()/2】
 * 3) 遍历s中的字符c，填充数组P。优化在于已知 center为一个回文串的中心字符，alength为该回文子串的臂长，
 * 那么以center+alength区间的字符为中心的回文串的长度可以由center-alength区间的字符为中心的回文串确定，从而减少了中心拓展的次数。具体的规则如下：
 * a.如果以center-i为中心的回文串的左边缘在以center为中心的回文串的左边缘以右，则P[center+i] = P[center-i];
 * b.如果以center-i为中心的回文串的左边缘与以center为中心的回文串的左边缘重合或在其之左，则P[center+i]需重新计算，但是不必从臂长0开始，可以从i+alength开始。
 */
public class Manacher {
    public static void main(String[] args) {
        new Manacher().manacher("cbbd");
    }

    //    求解最长回文子串
    public String manacher(String s) {
        StringBuilder t = new StringBuilder("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        s = t.toString();
        int[] P = new int[s.length()];
        int center = 1;
        P[1] = 1;
        for (int i = 2; i < P.length; i++) {
            if (i <= center + P[center]) {
                int mirror = 2 * center - i;
                if (mirror - P[mirror] > center - P[center]) {
                    P[i] = P[mirror];
                } else {
                    int aLength = Math.min(P[mirror], mirror - (center - P[center]));
                    int more = expand(s, i, aLength + 1);
                    P[i] = aLength + more;
                    if (i + P[i] > center + P[center]) {
                        center = i;
                    }
                }
            } else {
                P[i] = expand(s, i, 1);
                center = i;
            }
        }
//        寻找最大串，其实可以即时记录
        int max = 0;
        for (int i = 0; i < P.length; i++) {
            max = P[i] > P[max] ? i : max;
        }
        String substring = s.substring(max - P[max], max + P[max]);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < substring.length(); i++) {
            if (i % 2 != 0) {
                stringBuilder.append(substring.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private int expand(String s, int center, int start) {
        int result = 0;
        while (center - start >= 0 && center + start < s.length() && s.charAt(center - start) == s.charAt(center + start)) {
            result++;
            start++;
        }
        return result;
    }

}
