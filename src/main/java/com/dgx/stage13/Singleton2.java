package com.dgx.stage13;

/**
 * 懒汉   (静态常量)  (可用)
 * Create by dgx 2022-08-21 16:22
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2(){

    }


    public static  Singleton2 getInstance(){
        if (singleton2==null){
            return  new  Singleton2();
        }
        return  singleton2;
    }
}
