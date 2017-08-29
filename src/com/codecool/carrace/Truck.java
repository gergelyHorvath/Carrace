package com.codecool.carrace;

import java.util.Random;

class Truck extends Vehicle{

    private String name;
    private int distanceTraveled;
    private int speed;
    private int breakdownTurnsLeft;
    private String type;

    Truck() {
        this.setName();
        speed = 100;
        breakdownTurnsLeft = 0;
        distanceTraveled = 0;
        type = "Truck";
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

    private void setName() {
        Random rnd = new Random();
        this.name = String.valueOf(rnd.nextInt(1001));
    }

    void moveForAnHour() {
        this.breakDown();
        if (this.breakdownTurnsLeft > 0){
            breakdownTurnsLeft--;
        } else {
            this.distanceTraveled += this.speed;
        }
    }

    private void breakDown() {
        Random rnd = new Random();
        if (rnd.nextInt(100) < 5) this.breakdownTurnsLeft = 2;
    }
}
