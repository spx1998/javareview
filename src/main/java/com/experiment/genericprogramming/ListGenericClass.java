package com.experiment.genericprogramming;

import java.util.ArrayList;
import java.util.List;

public class ListGenericClass<T extends List> {
    T data;

    public ListGenericClass(T t) {
        data = t;
    }
}
