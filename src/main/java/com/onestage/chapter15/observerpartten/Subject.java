package com.onestage.chapter15.observerpartten;

public interface Subject {

    /***
     * 用以注册观察者
     * @param o 具体的观察者
     */
    void registerObserver(Observer o);

    /***
     * 用以删除观察者
     * @param o 具体的观察者
     */

    void removeObserver(Observer o);

    /***
     * 用以通知所有注册的观察者
     */
    void notifyObservers();
}
