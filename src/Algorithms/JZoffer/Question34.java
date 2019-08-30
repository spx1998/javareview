package Algorithms.JZoffer;

import java.util.LinkedHashMap;

public class Question34 {
    public static void main(String[] args) {
        Question34 question34 = new Question34();
        System.out.println(question34.FirstNotRepeatingChar("google"));
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