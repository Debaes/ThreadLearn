package com.dgx.stage13;

/**
 * 懒汉   双重检测
 * Create by dgx 2022-08-21 16:22
 */
public class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4(){

    }


    public static synchronized Singleton4 getInstance(){
        if (singleton4==null){
            synchronized (Singleton3.class){
                if(singleton4==null){
                    singleton4 =       new Singleton4();
                }
            }
        }
        return  singleton4;
    }

    private  long temp=0;

    public    synchronized void  setTemp(){
       temp =100;
    }
}
