package IODemo.main;

import IODemo.client.AioClient;
import IODemo.server.AioServer;

import java.util.Scanner;

public class AioTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        //运行服务器
        AioServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        AioClient.start();
        Thread.sleep(100);
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while(AioClient.sendMsg(scanner.nextLine()));
    }

}
