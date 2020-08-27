package com.IODemo.client;

public class NioClient {
    private static final int PORT = 23456;
    private static final String IP = "127.0.0.1";
    private static NioHandle nioHandle;
    public static void start() {
        start(PORT);
    }
    public static synchronized void start(int port){
        if(nioHandle != null){
            nioHandle.stop();
        }
        nioHandle = new NioHandle(IP,port);
        new Thread(nioHandle,"Client").start();
    }
    public static boolean sendMsg(String msg) throws Exception {
        if("q".equals(msg))return false;
        nioHandle.sendMsg(msg);
        return true;
    }

    public static void main(String[] args) {
        start();
    }
}
