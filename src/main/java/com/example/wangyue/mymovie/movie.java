package com.example.wangyue.mymovie;

import android.os.Parcel;
import android.os.Parcelable;

public class movie implements Parcelable{
    private String Name;
    private String time;
    private String Actor;
    private String Address;
    private String Description;
    private String Director;
    private String Genre;

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


    private String Price;

    protected movie(Parcel in) {
        Name = in.readString();
        time = in.readString();
        Actor = in.readString();
        Address = in.readString();
        Description = in.readString();
        Director = in.readString();
        Genre = in.readString();
        Price = in.readString();
    }

    public static final Creator<movie> CREATOR = new Creator<movie>() {
        @Override
        public movie createFromParcel(Parcel in) {
            return new movie(in);
        }

        @Override
        public movie[] newArray(int size) {
            return new movie[size];
        }
    };
    public String toString(){
        String s ="Price: "+getPrice()+"\nAddress:" + getAddress() + "\nName: "+ getName() + "\nActor:" + getActor() +
                "\n Director: " + getDirector() + "\nTime:" + getTime() + "\nGenre" + getGenre() +
                "\nDescription: " + getDescription();
        return s;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }




    public movie(){

    }
    public movie(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(time);
        dest.writeString(Actor);
        dest.writeString(Address);
        dest.writeString(Description);
        dest.writeString(Director);
        dest.writeString(Genre);
        dest.writeString(Price);
    }
}
