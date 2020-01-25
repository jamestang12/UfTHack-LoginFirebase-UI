package com.example.ufthack;

public class Contact {

    private String name;
    private String xp;
    private int Photo;
    private String rank;
    private String days;

    public Contact(){

    }

    public Contact(String name, String xp, int Photo, String rank, String days){
        this.name = name;
        this.rank = rank;
        this.xp = xp;
        this.days = days;
        this.Photo = Photo;
    }

    public String getRank(){
        return this.rank;
    }

    public String getDays(){
        return this.days;
    }

    public void setDays(String days){
        this.days = days;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public String getName(){
        return this.name;
    }

    public String getXp(){
        return this.xp;
    }

    public int getPhoto() {
        return this.Photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXp(String xp){
        this.xp = xp;
    }

    public void setPhoto(int Photo){
        this.Photo = Photo;
    }
}
