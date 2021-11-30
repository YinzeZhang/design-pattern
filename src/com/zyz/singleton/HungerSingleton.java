package com.zyz.singleton;

/**
 * 饿汉式
 * 在类加载时，直接将实例对象初始化，并且该实例是静态的，
 * 属于类的成员变量，通过调用类的静态方法返回该对象。　　
 *
 * 运行testSingleton单元测试，输出的两行都是lisi，
 * 因为s1,s2指向的同一个实例对象，这个对象在类创建的时候就存在了。
 *
 * 饿汉式是线程安全的，不管系统的那一个线程获取这个对象，他们都是该类同一个对象。缺点是在程序在一开始就创建了该对象，占用内存空间。下面这种实现方式增加判断，在程序调用时才实例化该对象。
 */
public class HungerSingleton {

    private static HungerSingleton singleton = new HungerSingleton();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private HungerSingleton() {

    }

    public static HungerSingleton getInstance(){
        return singleton;
    }

}
