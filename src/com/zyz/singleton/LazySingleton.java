package com.zyz.singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton = null;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LazySingleton() {
    }

    /**
     * 当多个线程同时访问getInstance()方法时，
     * 有可能在第一个线程进入if语句是还没new Singleton()时，
     * 这时第二个线程判断if的时候就会为真，则会创建新的实例，
     * 这时需要在getInstance()方法上添加synchronized修饰符,表示线程同步
     * @return
     */
    public static synchronized LazySingleton getInstance(){
        if(lazySingleton != null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
