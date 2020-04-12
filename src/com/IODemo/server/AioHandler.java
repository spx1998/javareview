package com.IODemo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AioHandler implements Runnable {
    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;
    public AioHandler(int port){
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            System.out.println("Aio服务器已开启，端口号："+port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        channel.accept(this,new AcceptHandler());
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
