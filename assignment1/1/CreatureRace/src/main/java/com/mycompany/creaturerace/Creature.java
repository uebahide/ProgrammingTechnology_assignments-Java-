/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creaturerace;

import java.util.ArrayList;

/**
 *
 * @author uewashuuwa
 */
abstract class Creature {
    protected String name;
    protected int water;
    protected int maxWater;
    protected boolean living = true;
    protected int distance = 0;

    protected Creature(String name, int water) {
        this.name = name;
        this.water = water;
    }
    
    protected abstract void move(Day day);
    public void modifyWater(int v){water+=v; if(water <= 0) dead();}
    public void modifyDistance(int d) { distance+=d;}
    public void dead(){living = false;}
    public boolean isAlive(){return living;}
    public String getName(){return name;}
    public int getDistance(){return distance;}
    public void race(ArrayList<Day> days){
        int i = 0;
        while(i < days.size() && living){
            move(days.get(i));
            i++;
        }
    }
    
    @Override
    public String toString(){
        return getName() + ": " + getDistance();
    }
}
class Sandrunner extends Creature{
    public Sandrunner(String name, int water){
        super(name, water);
        maxWater = 8;
    }

    @Override
    public void move(Day day){
       day.ChangeSR(this);
    }
}

class Sponge extends Creature{
    public Sponge(String name, int water){
        super(name, water);
        maxWater = 20;
    }

    @Override
    public void move(Day day){
       day.ChangeSG(this);
    }
}

class Walker extends Creature{
    public Walker(String name, int water){
        super(name, water);
        maxWater = 12;
    }

    @Override
    public void move(Day day){
       day.ChangeWK(this);
    }
}

