package Algorithms.leetcode_DP;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 超时
 */
public class Solution44 {
    public static void main(String[] args) {
        System.out.println(new Solution44().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
    public boolean isMatch(String s, String p) {
        //需补充p s null的情况
        if(p==null){
            return s==null;
        }
        if(s==null){
            for(char c:p.toCharArray()){
                if(c!='*')
                    return false;
            }
            return true;
        }
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int count=0;
        for(int i=1;i<ps.length;i++){
            if(ps[i]==ps[i-1]&&ps[i]=='*'){
                count++;
                System.arraycopy(ps, i, ps, i - 1, ps.length - i);
                ps[ps.length-count]='0';
                i--;
            }
        }
        char[] newPs = new char[ps.length-count];
        for(int i=0;i<newPs.length;i++){
            newPs[i]=ps[i];
        }
        return match(ss,newPs,0,0);
    }

    private boolean match(char[] ss, char[] ps, int i, int j) {
        if(j==ps.length){
            return ss.length==i;
        }
        if(i==ss.length){
            for(;j<ps.length;j++){
                if(ps[j]!='*')
                    return false;
            }
            return true;
        }
        if(ss[i]==ps[j]||ps[j]=='?'){
            return match(ss,ps,i+1,j+1);
        }else if(ps[j]=='*'){
            return match(ss,ps,i,j+1)||match(ss,ps,i+1,j);
        }return false;
    }
}
