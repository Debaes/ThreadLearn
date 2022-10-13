package com.dgx.stage13;

/**
 * 类加载的时候就实例化
 * jvm 保证线程安全
 * 饿汉式   (静态常量)  (可用)
 * Create by dgx 2022-08-21 16:22
 */
public class Singleton1 {
    private  final  static  Singleton1  INSTANCE=new Singleton1();


    private Singleton1(){

    }
}
