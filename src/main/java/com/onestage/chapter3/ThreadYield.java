package com.onestage.chapter3;

public class ThreadYield {
    public static void main(String[] args) {
        String str = "rewrwerw";
        Boolean isNumber = str.matches("-?[0-9]+.*[0-9]*");
        System.out.println(isNumber);
    }
}
