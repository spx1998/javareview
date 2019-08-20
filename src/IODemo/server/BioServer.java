package IODemo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    private static final int PORT = 12345;
    private static ServerSocket bioServer ;
    public static void start() throws IOException {
        start(PORT);
    }
    public synchronized static void start(int port) throws IOException {
        if(bioServer!=null) {
            return;
        }
        try{
            bioServer=new ServerSocket(port);
            System.out.println("bio服务器开启，port："+port);
            while (true){
                Socket socket =bioServer.accept();
                new Thread(new BioHandler(socket)).start();
            }
        }finally {
            if(bioServer!=null) {
                bioServer.close();
                System.out.println("bio服务器已关闭");
                bioServer=null;
            }
        }

    }


}

