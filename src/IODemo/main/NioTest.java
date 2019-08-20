package IODemo.main;

import IODemo.client.NioClient;
import IODemo.server.NioServer;

import java.util.Scanner;

public class NioTest {
    public static void main(String[] args) throws Exception {
        NioServer.start();
        Thread.sleep(100);
        NioClient.start();
        while (NioClient.sendMsg(new Scanner(System.in).nextLine()));
    }
}
