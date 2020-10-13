package com.experiment.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandleImpl implements InvocationHandler {

    Object o;

    InvocationHandleImpl() {
        this.o = new ServiceImpl();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre");
        Object invoke = method.invoke(o, args);
        System.out.println("after");
        return invoke;
    }
}
