package com.designpatterns;

/**
 * @author spx
 * 单例模式的实现
 */
public class Singleton {

//    /**
//     * 避免该类在外部被实例化,同时避免反射造成的单例破坏。
//     */
//    private Singleton() {
//        if (uniqueInstance !=null){
//            throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取");
//        }
//    }
    //如果实现了Serializable接口，避免反序列化造成单例破坏。
//    public Object readResolve() throws ObjectStreamException {
//        return uniqueInstance;
//    }

    //饿汉式(线程安全)  随类的创建而创建 无延迟实例化
//    private static Singleton uniqueInstance = new Singleton();
//    public static Singleton getInstance(){
//        return uniqueInstance;
//    }

    //懒汉式(线程不安全) 延迟实例化
//    private static Singleton uniqueInstance;
//    public static Singleton getInstance(){
//        if(uniqueInstance==null){
//            uniqueInstance=new Singleton();
//        }
//        return uniqueInstance;
//    }

    //懒汉式(线程安全) 用synchronized锁保证线程安全 性能差
//    private static volatile Singleton uniqueInstance;
//    public static synchronized Singleton getInstance(){
//        if (uniqueInstance==null){
//            uniqueInstance = new Singleton();
//        }
//        return uniqueInstance;
//    }

    //双重校验锁(线程安全) volatile取消指令重排序 性能比懒汉式好
//    private static volatile Singleton uniqueInstance;
//    public static Singleton getInstance(){
//        if(uniqueInstance==null){
//            synchronized (Singleton.class){
//                if(uniqueInstance==null){
//                    uniqueInstance =new Singleton();
//                }
//            }
//        }
//        return uniqueInstance;
//    }

    //静态内部类(线程安全)
    // jvm保证类的初始化的线程安全;
    // singleton类加载时，静态内部类不会被加载，调用getInstance才被加载，保证了延迟实例化。
//    private static class SingletonHolder{
//        private static final Singleton uniqueInstance = new Singleton();
//    }
//    public static Singleton getInstance(){
//        return SingletonHolder.uniqueInstance;
//    }

     //枚举实现 防止反射攻击
//    public Singleton getInstance(){
//        return SingletonEnum.SINGLETON_ENUM.getInstance();
//    }
//    public enum SingletonEnum{
//        //枚举实例默认是static final的
//        SINGLETON_ENUM;
//        private final Singleton singleton;
//        SingletonEnum() {
//            singleton = new Singleton();
//        }
//        public Singleton getInstance(){
//            return singleton;
//        }
//    }
}

