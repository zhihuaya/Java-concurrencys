package com.onestage.chapter15.observerpartten;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;    //温度
    private float humidity;       //湿度
    private Subject weatherData;  //主题

    // 当前布告板 构造之时 订阅 了 主题
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    // 显示
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("1,当前布告板: 温度" + temperature + "度,湿度" + humidity + "%");
    }

    // 更新
    public void update(float temperature, float humidity, float pressure) {
        // TODO Auto-generated method stub
        this.temperature = temperature;
        this.humidity = humidity;

        display();
    }

}
