package com.onestage.chapter2;

public class Bank {

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow("柜台1");
        ticketWindow.start();
        TicketWindow ticketWindow1 = new TicketWindow("柜台2");
        ticketWindow1.start();
        TicketWindow ticketWindow2 = new TicketWindow("柜台3");
        ticketWindow2.start();

    }

}
