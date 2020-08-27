package com.IODemo.server;

public class NioServer {
    private static final int PORT =23456;
    private static NioHandle nioHandle;
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        start(PORT);
    }
    public static synchronized void start(int port){
        if(nioHandle !=null){
            nioHandle.stop();
        }
        nioHandle = new NioHandle(port);
        new Thread(nioHandle,"Server").start();
    }

}
