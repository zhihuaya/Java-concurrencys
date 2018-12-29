package com.onestage.chapter9;

public class ActiveLoadTest {

    public static void main(String[] args) {
        System.out.println(Child.x);

        Parent[] parents = new Parent[10];
        System.out.println(parents.length);

        System.out.println(Parent.y);
    }

}
