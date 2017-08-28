package com.codecool.carrace;

import java.util.Random;

class Truck {

    int name;
    int distanceTraveled;
    private int speed;
    private int breakdownTurnsLeft;

    Truck() {
        this.setName();
        speed = 100;
        breakdownTurnsLeft = 0;
        distanceTraveled = 0;
    }

    private void setName() {
        Random rnd = new Random();
        this.name = rnd.nextInt(1001);
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
