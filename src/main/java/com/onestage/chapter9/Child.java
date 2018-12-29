package com.onestage.chapter9;

public class Child extends Parent{

    static {
        System.out.println("The child is initialized");
    }

    public static int x = 10;
}
