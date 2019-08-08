package multithreading;

import static java.lang.Thread.sleep;

public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(()->{while (true){
            System.out.println("i am daemon thread");
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }});
        daemon.setDaemon(true);//必须在start之前设置 否则报错并作为用户线程执行
        daemon.start();
        sleep(1000);

    }
}
