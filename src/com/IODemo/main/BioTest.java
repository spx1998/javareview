package com.IODemo.main;

import com.IODemo.client.BioClient;
import com.IODemo.server.BioServer;

import java.io.IOException;
import java.util.Scanner;

public class BioTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                BioServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(100);
        Scanner scanner =new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str = scanner.next();
            String finalStr = str;
            new Thread(() -> BioClient.send(finalStr)).start();
        }

        scanner.close();
    }

}
