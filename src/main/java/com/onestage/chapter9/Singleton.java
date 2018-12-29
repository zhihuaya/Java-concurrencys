package com.onestage.chapter9;

public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y;


    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getSingleton(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = getSingleton();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
