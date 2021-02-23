package com.experiment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
//        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.forEach(o -> System.out.println(o + 1));
        list.stream().skip(100).forEach(System.out::println);

//        lists.add(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
//        lists.add(IntStream.range(5, 10).boxed().collect(Collectors.toList()));
//        lists.add(IntStream.range(10, 15).boxed().collect(Collectors.toList()));
//        //flatMap将流中的每个元素转换为流
//        lists.stream().flatMap(Collection::stream).forEach(System.out::println);
//
//        List<String> list = new ArrayList<>();
//        list.add(null);
//        list.add("str");
//        list.stream().filter(Objects::nonNull).forEach(System.out::println);
//        String str = null;
//
//        String s = Optional.ofNullable(str).orElse("string");
//        Optional.ofNullable(s).ifPresent(System.out::println);
    }
}
