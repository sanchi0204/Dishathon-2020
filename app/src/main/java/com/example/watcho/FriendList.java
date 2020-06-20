package com.example.watcho;

import android.app.Application;

import com.example.watcho.Fragments.Friends;

import java.util.ArrayList;

public class FriendList extends Application {


    private ArrayList<String> Name=new ArrayList<String>(10) ;
    private ArrayList<String> gen1=new ArrayList<String>(10) ;
    private ArrayList<String > gen2=new ArrayList<String>(10) ;
    private ArrayList<String > gen3=new ArrayList<String>(10) ;

    public void addName(int i, String s)
    {
        Name.add(i, s);
    }
    public void addGen1(int i, String s)
    {
        gen1.add(i, s);
    }
    public void addGen2(int i, String s)
    {
        gen2.add(i, s);
    }
    public void addGen3(int i, String s)
    {
        gen3.add(i, s);
    }

    public String getName(int i)
    {
        String s= Name.get(i).toString();
        return s;
    }
    public String getGen1(int i)
    {
        String s= gen1.get(i).toString();
        return s;
    }
    public String getGen2(int i)
    {
        String s= gen2.get(i).toString();
        return s;
    }
    public String getGen3(int i)
    {
        String s= gen3.get(i).toString();
        return s;
    }

    public ArrayList getName() {
        return Name;
    }

    public void setName(ArrayList name) {
        Name = name;
    }

    public ArrayList getGen1() {
        return gen1;
    }

    public void setGen1(ArrayList gen1) {
        this.gen1 = gen1;
    }

    public ArrayList getGen2() {
        return gen2;
    }

    public void setGen2(ArrayList gen2) {
        this.gen2 = gen2;
    }

    public ArrayList getGen3() {
        return gen3;
    }

    public void setGen3(ArrayList gen3) {
        this.gen3 = gen3;
    }
}