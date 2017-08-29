package com.codecool.carrace;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Main {

    private List<Vehicle> vehicleList = new ArrayList<>();
    static boolean isRaining;

    private void createVehicles(){
        int numberOfVehicles = 10;
        for (int i = 0; i < numberOfVehicles; i++) {
            this.vehicleList.add(new Car());
            this.vehicleList.add(new MotorCycle());
            this.vehicleList.add(new Truck());
        }
    }

    private void simulateRace(){
        for (int i = 0; i < 50; i++){
            Random rnd = new Random();
            isRaining = (rnd.nextInt(100) < 30);
            int rainSpeed = (isRaining)? 70: 0;
            Car.setSpeedLimit(rainSpeed);

            /*for (int idx = 0; idx < this.vehicleList.size(); idx++){
                this.vehicleList.get(idx).moveForAnHour();
            }*/
            for (Vehicle vehicle: vehicleList){
                vehicle.moveForAnHour();
            }
        }
    }

    private void printRaceResults(){
        for (Vehicle vehicle: vehicleList){
            System.out.printf("Name: %s, Distance(km): %s, Type: %s %n",
                    vehicle.getName(),
                    vehicle.getDistanceTraveled(),
                    vehicle.getType());
        }
    }

    private void sortByDistance(){
        vehicleList.sort(Comparator.comparing(Vehicle::getDistanceTraveled));
        Collections.reverse(vehicleList);
    }

    public static void main(String[] args) {
        Main race = new Main();
        race.createVehicles();
        race.simulateRace();
        race.sortByDistance();
        race.printRaceResults();
    }
}
