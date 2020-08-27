package com.IODemo.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioHandler> {

    @Override
    public void completed(AsynchronousSocketChannel channel, AioHandler aioHandler) {
        AioServer.clientCount++;
        System.out.println("连接数："+AioServer.clientCount);
        aioHandler.channel.accept(aioHandler,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer,buffer,new ReadHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AioHandler aioHandler) {
        exc.printStackTrace();
        aioHandler.latch.countDown();
    }
}
