package com.IODemo.server;

public class AioServer {
    private static final int PORT = 3333;
    private static AioHandler aioHandle;
    public volatile static long clientCount = 0;
    public static void start(){
        start(PORT);
    }
    private static synchronized void start(int port){
        if(aioHandle != null)
            aioHandle = null;
        aioHandle =new AioHandler(port);
        new Thread(aioHandle,"Server").start();
    }

    public static void main(String[] args) {
        start();
    }
}
