package IODemo.client;

public class AioClient {
    private static final int PORT = 3333;
    private static final String IP = "127.0.0.1";
    private static AioClientHandler clientHandle;
    public static void start(){
        start(IP,PORT);
    }
    public static synchronized void start(String ip,int port){
        if(clientHandle!=null)
            return;
        clientHandle = new AioClientHandler(ip,port);
        new Thread(clientHandle,"Client").start();
    }
    public static boolean sendMsg(String msg) throws InterruptedException {
        if("q".equals(msg))return false;
        clientHandle.sendMsg(msg);
        return true;
    }

}
