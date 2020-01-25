package com.example.ufthack;

public class VapeTime {

    private String amount,hour,min;

    public VapeTime(String amount,String hour,String min){
        this.amount = amount;
        this.hour = hour;
        this.min = min;
    }

    public String getAmount(){
        return this.amount;
    }

    public String getHour(){
        return hour;
    }

    public String getMin(){
        return min;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

    public void setHour(String hour){
        this.hour = hour;
    }

    public void setMin(String min){
        this.min = min;
    }
}
