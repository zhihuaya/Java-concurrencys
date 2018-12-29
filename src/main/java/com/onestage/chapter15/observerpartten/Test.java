package com.onestage.chapter15.observerpartten;

public class Test {

    public static void main(String[] args) {
        // 1,新建一个天气主题
        WeatherData weatherData = new WeatherData();

        // 2,新建显示1-当前状态，显示2-气象统计，显示3-天气预报
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);

        StatisticsDisplay statisticsDisplay =
                new StatisticsDisplay(weatherData);

        // 3,主题更新了相关数据
        weatherData.setMeasurements(20, 65, 30.4f);
        weatherData.setMeasurements(30, 70, 29.2f);
        weatherData.setMeasurements(25, 90, 29.2f);

    }

}
