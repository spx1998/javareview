package IODemo.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AioClientHandler implements CompletionHandler<Void,AioClientHandler>,Runnable {
    private AsynchronousSocketChannel clientChannel;
    private String host;
    private int port;
    private CountDownLatch latch;
    public AioClientHandler(String host,int port){
        this.host = host;
        this.port = port;
        try{
            clientChannel = AsynchronousSocketChannel.open();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        clientChannel.connect(new InetSocketAddress(host,port),this,this);
        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void completed(Void result, AioClientHandler attachment) {
        System.out.println("连接成功");
    }

    @Override
    public void failed(Throwable exc, AioClientHandler attachment) {
        System.out.println("连接失败");
        exc.printStackTrace();
        try {
            clientChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String msg){
        byte[] req = msg.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        clientChannel.write(writeBuffer, writeBuffer,new WriteHandler(clientChannel, latch));
    }
}
