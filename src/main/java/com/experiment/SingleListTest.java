package com.experiment;

import java.util.Collections;
import java.util.List;

/**
 * sigletionList 不能增加元素
 */
public class SingleListTest {
    public static void main(String[] args) {
        List<Integer> list = Collections.singletonList(1);
        list.add(2);
    }
}
