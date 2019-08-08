package multithreading;

public class NewThread {
    public static void main(String[] args) {
        Thread thread1 =new Thread(){@Override public void run(){//重写run接口
            int i=0;
            while (i<100) {
                System.out.println(" thread1！");

                i++;
            }
        }};
        Thread thread2 = new Thread(()->{//使用构造方法，传入实现了runnable接口的对象
            int i=0;
            while (i<100) {
                System.out.println(" thread2!");
                i++;
            }
        });
        thread1.start();
        thread2.start();
    }
}
