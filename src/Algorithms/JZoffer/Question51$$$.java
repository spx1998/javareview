package Algorithms.JZoffer;

public class Question51$$$ {
    public static void main(String[] args) {
        Question51$$$ question51 = new Question51$$$();
        System.out.println(question51.match("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
    }
    public boolean match(char[] str, char[] pattern){
        if(str==null||pattern==null)return false;
        int strIndex = 0;
        int patternIndex =0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if(patternIndex+1< pattern.length&pattern[patternIndex+1]=='*'){
            if((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])||(pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchCore(str,strIndex,pattern,patternIndex+2)||matchCore(str, strIndex + 1, pattern, patternIndex + 2)||matchCore(str, strIndex + 1, pattern, patternIndex);
            }
        }
        if((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])|| (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}

