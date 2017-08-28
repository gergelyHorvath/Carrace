package com.codecool.carrace;

import java.util.Random;

class MotorCycle {

    String name;
    private int normalSpeed;
    int distanceTraveled;
    static int nameNumber = 1;


    MotorCycle(){
        this.setName();
        normalSpeed = 100;
        distanceTraveled = 0;
    }

    private void setName(){
        this.name = "Motorcycle " + nameNumber++;
    }

    void moveForAnHour(boolean isRaining){
        Random rnd = new Random();
        this.distanceTraveled += this.normalSpeed;
        if (isRaining) distanceTraveled -= rnd.nextInt(46) + 5;
    }
}
