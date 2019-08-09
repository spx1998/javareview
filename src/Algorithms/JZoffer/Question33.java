package Algorithms.JZoffer;

import java.util.LinkedHashMap;

public class Question33 {
    public static void main(String[] args) {
        Question33 question33 = new Question33();
        System.out.println(question33.FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        for(char c:str.toCharArray()){
            linkedHashMap.merge(c, 1, Integer::sum);
        }
        char ch = 0;
        for(char c:linkedHashMap.keySet()){
            if(linkedHashMap.get(c)==1){
                ch=c;
                break;
            }
        }
        if(ch==0) return -1;
        return str.indexOf(ch);
    }
}