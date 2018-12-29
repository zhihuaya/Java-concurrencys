package com.onestage.chapter16;

public class FlightSecurity {

    private int count = 0;
    //登机牌
    private String boardingPass = "null";
    //身份证
    private String idCard = "null";

    public void pass(String boardingPass, String idCard) {
        synchronized (this) {
            this.boardingPass = boardingPass;
            this.idCard = idCard;
            this.count++;
            check();
        }
    }

    public void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("=====Exception========" + toString());
        }else{
            System.out.println("pass");
        }
    }

    @Override
    public String toString() {
        return "FlightSecurity{" +
                "count=" + count +
                ", boardingPass='" + boardingPass + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
