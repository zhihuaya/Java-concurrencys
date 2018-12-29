package com.onestage.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {
        readFromDataBase();
        writeDataToFile();
    }

    private static void writeDataToFile(){
        try {
            println("begin wirte from database");
            Thread.sleep(1000*10L);
            println("wirte  start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("wirte finish and successfully");
    }

    private static void readFromDataBase(){
        try {

            println("begin read from database");
            Thread.sleep(1000*10L);
            println("read start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("read finish and successfully");
    }

    private static void println(String massage){
        System.out.println(massage);
    }
}
