package com.experiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        lists.add(IntStream.range(5, 10).boxed().collect(Collectors.toList()));
        lists.add(IntStream.range(10, 15).boxed().collect(Collectors.toList()));
        //flatMap将流中的每个元素转换为流
        lists.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
