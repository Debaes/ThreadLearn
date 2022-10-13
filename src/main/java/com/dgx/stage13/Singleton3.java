package com.dgx.stage13;

/**
 * 懒汉   (静态常量)  (可用)
 * Create by dgx 2022-08-21 16:22
 */
public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3(){

    }


    public static synchronized  Singleton3 getInstance(){
        if (singleton3==null){
            return  new Singleton3();
        }
        return  singleton3;
    }
}
