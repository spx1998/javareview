package multithreading;

import static java.lang.Thread.sleep;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                System.out.println("i am alive!");
                try {
                    sleep(100);
                } catch (InterruptedException e) {//会清除中断标记
                    System.out.println("interrupt when sleep");
                    Thread.currentThread().interrupt();//重设interrupt状态
                }
                if(Thread.currentThread().isInterrupted()){//如果没有处理中断的逻辑，该线程将不会中断，一直循环。
                    System.out.println("a!wsl!");
                    break;
                }
            }
        });
        thread.start();
        sleep(1000);
        thread.interrupt();
    }
}
