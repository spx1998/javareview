package com.experiment.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author sunpengxiang
 */
public class ProxyTest {
    public static void main(String[] args) {

        Service service = (Service)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{Service.class}, new InvocationHandleImpl());
        service.doSomething();
    }
}
