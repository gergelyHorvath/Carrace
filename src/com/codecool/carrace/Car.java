package com.codecool.carrace;

import java.util.Random;

class Car {

    String name;
    private int normalSpeed;
    int distanceTraveled;

    private static int speedLimit;

    Car(){
        this.setName();
        this.setNormalSpeed();
        distanceTraveled = 0;
    }

    static void setSpeedLimit(int limit){
        speedLimit = limit;
    }

    private void setName() {
        Random rnd = new Random();
        String[] possibleNames = {
                "Epiphany", "Renegade", "Legend", "Formula", "Umbra",
                "Deputy", "Formula", "Catalyst", "Utopia", "Wolf"
        };
        int size = possibleNames.length;
        this.name = possibleNames[rnd.nextInt(size)] + " " + possibleNames[rnd.nextInt(size)];
    }

    private void setNormalSpeed(){
        Random rnd = new Random();
        this.normalSpeed = rnd.nextInt(31) + 80;
    }

    void moveForAnHour(){
        this.distanceTraveled += (speedLimit == 0)? normalSpeed: speedLimit;
    }
}
