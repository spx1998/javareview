package com.algorithms.JZoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Question27 {
    public static void main(String[] args) {
        Question27 question27 = new Question27();

        System.out.println(Arrays.toString(question27.Permutation("abc").toArray()));
    }
    private ArrayList<String> arrayList ;
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.equals(""))return new ArrayList<>();
        arrayList = new ArrayList<>();
        createString(str,new ArrayList<>());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(arrayList);
        return new ArrayList<>(hashSet);
    }

    private void createString(String str,ArrayList<Character> charList) {
        if(str.equals("")) {
            StringBuilder sb =new StringBuilder();
            for (char c:charList){
                sb.append(c);
            }
            arrayList.add(sb.toString());
           return;
        }
        char[] cs = str.toCharArray();
        for(int i=0;i<cs.length;i++){
            charList.add(cs[i]);
            StringBuilder newstr =new StringBuilder() ;
            for(int j=0;j<cs.length;j++){
                if(j==i){
                    continue;
                }
                newstr.append(cs[j]);
            }
            createString(newstr.toString(),charList);
            charList.remove(charList.size()-1);
        }
    }
}
