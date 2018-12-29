package com.onestage.chapter16;

public class EatNoodleThread extends Thread {

    private final String name;

    private final Tableware leftTool;

    private final Tableware roghtTool;

    public EatNoodleThread(String name,
                           Tableware leftTool,
                           Tableware roghtTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.roghtTool = roghtTool;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    public void eat() {
        synchronized (leftTool) {
            System.out.println(name + "take up" + leftTool + "(left)");
            synchronized (roghtTool) {
                System.out.println(name + "take up" + roghtTool + "right");
                System.out.println(name + "is eating now");
                System.out.println(name + "put down" + roghtTool + "right");
            }
            System.out.println(name + "put down" + leftTool + "left");
        }
    }

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A",fork,knife).start();
        new EatNoodleThread("B",knife,fork).start();
    }
}
