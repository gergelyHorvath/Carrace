package com.codecool.carrace;

import java.util.Random;

class MotorCycle extends Vehicle{


    private String name;
    private int normalSpeed;
    private int distanceTraveled;
    private String type;
    private static int nameNumber = 1;

    MotorCycle(){
        this.setName();
        normalSpeed = 100;
        distanceTraveled = 0;
        type = "Motorcycle";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String getType() {
        return type;
    }

    private void setName(){
        this.name = "Motorcycle " + nameNumber++;
    }

    void moveForAnHour(){
        Random rnd = new Random();
        this.distanceTraveled += this.normalSpeed;
        if (Main.isRaining) distanceTraveled -= rnd.nextInt(46) + 5;
    }
}
