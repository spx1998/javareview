package com.IODemo.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioHandler implements Runnable {
    private Socket socket;
    public BioHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String expression;
            String result;
            while (true){
                if((expression = in.readLine())==null) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+" get:"+expression);
                result = expression+"!!";
                //活跃线程=主线程(main +Monitor-ctrl-Break)+client线程（活跃）+server线程（活跃）
                System.out.println("活跃线程数： "+Thread.activeCount());
                // 模拟计算过程
                Thread.sleep(10000);
                out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}