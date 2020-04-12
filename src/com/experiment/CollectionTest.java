package com.experiment;

import java.util.*;

/**
 * @author spx
 */
public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String,String> hashMap = new HashMap<>();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add(null);
        arrayList.add(null);
        System.out.println("arrayList.size= "+arrayList.size());//4
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet.size= "+hashSet.size());//2
        hashMap.put("a","a");
        hashMap.put("a","b");
        hashMap.put(null,"a");
        hashMap.put(null,"c");
        System.out.println("hashMap.size= "+hashMap.size());//2
//        Hashtable<String,String> hashtable = new Hashtable<>();
//        hashtable.put(null,"a");  报错，hashtable 不允许将null作为键值。
        for(String s : arrayList){//遍历arrayList
            System.out.print(s + " ");//a a null null -> 与插入顺序相符
        }
        System.out.println();

        for (String s : hashSet) {//遍历hashSet
            System.out.print(s + " ");//null a ->与插入顺序不符
        }
        System.out.println();
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("e");
        treeSet.add("d");
        for(String s : treeSet){//遍历treeSet
            System.out.print(s + " ");//a b d e -> sort的顺序
        }
        System.out.println();
        for(String s:hashMap.keySet()){//遍历hashMap的keyset
            System.out.print(s+" ");//null a -> 与插入顺序不符合
        }
        treeSet.last();//treeSet，存在last()方法
//        hashSet.last(); hashSet无序，该方法不存在
    }
}
