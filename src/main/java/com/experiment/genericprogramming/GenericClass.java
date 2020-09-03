package com.experiment.genericprogramming;

import java.util.Arrays;
import java.util.List;

public class GenericClass<T> {
    private T data;

    GenericClass(){}

    GenericClass(T t){
        this.data = t;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public <E> void genericMethod(E e){
        System.out.println("i am a instance of" + e.getClass());
    }


}
