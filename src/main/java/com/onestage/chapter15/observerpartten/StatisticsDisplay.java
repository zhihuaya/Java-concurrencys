package com.onestage.chapter15.observerpartten;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0.0f;  // 最高温度
    private float minTemp = 0.0f;  // 最低温度
    private float tempSum = 0.0f;  // 温度更新和
    private int numReadings;       // 温度更新次数

    Subject weatherData;           // 主题

    // 同 显示1
    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    // 显示
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("2,平均温度：" + (tempSum / numReadings) + ",最大温度："
                + maxTemp + ",最小温度：" + minTemp);
    }

    // 更新
    public void update(float temperature, float humidity, float pressure) {
        // TODO Auto-generated method stub

        // 统计温度和次数 用以算出平均温度
        float temp = temperature;
        tempSum += temp;
        numReadings++;

        // 设置最高温度
        if (temp > maxTemp) {
            maxTemp = temp;
        }
        // 设置最低温度
        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }
}
