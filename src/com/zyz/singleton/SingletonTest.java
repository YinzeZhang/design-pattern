package com.zyz.singleton;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void testHungerSingleton(){
        HungerSingleton s1 = HungerSingleton.getInstance();
        HungerSingleton s2 = HungerSingleton.getInstance();
        s1.setName("zhang");
        s2.setName("yinze");
        System.out.println(s1.getName());
        System.out.println(s2.getName());
    }
}
