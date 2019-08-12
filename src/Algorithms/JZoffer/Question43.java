package Algorithms.JZoffer;

import java.util.ArrayList;

public class Question43 {
    public static void main(String[] args) {
        Question43 question43 =new Question43();

        String s = question43.ReverseSentence(" ");
        System.out.println("a"+s+"b");
    }
    public String ReverseSentence(String str) {
        //不一定是几个空格
        if(str.trim().equals("")) return str;
        char[] chars = str.toCharArray();
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c:chars){
            if(c==' '){
                arrayList.add(stringBuilder);
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(c);
        }
        arrayList.add(stringBuilder);
        String result = "";
        for(int i=arrayList.size()-1;i>=0;i--){
            result =result+arrayList.get(i)+" ";
        }
        return result.trim();
    }
}
