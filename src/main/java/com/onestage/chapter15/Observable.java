package com.onestage.chapter15;

public interface Observable {

    enum Cycle{
        STAETED,RUNNING,DONE,ERROE
    }

    Cycle getCycle();

    void start();

    void interrupt();

}
