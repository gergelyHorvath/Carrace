package com.codecool.carrace;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class Main {

    private List<Car> carList = new ArrayList<>();
    private List<MotorCycle> bikeList = new ArrayList<>();
    private List<Truck> truckList = new ArrayList<>();
    private static boolean isRaining;

    private void createVehicles(){
        int numberOfVehicles = 10;
        for (int i = 0; i < numberOfVehicles; i++) {
            this.carList.add(new Car());
            this.bikeList.add(new MotorCycle());
            this.truckList.add(new Truck());
        }
    }

    private void simulateRace(){
        for (int i = 0; i < 50; i++){
            Random rnd = new Random();
            isRaining = (rnd.nextInt(100) < 30);
            int rainSpeed = (isRaining)? 70: 0;
            Car.setSpeedLimit(rainSpeed);

            for (int idx = 0; idx < this.carList.size(); idx++){
                this.carList.get(idx).moveForAnHour();
                this.bikeList.get(idx).moveForAnHour(isRaining);
                this.truckList.get(idx).moveForAnHour();
            }
        }
    }


    private void printRaceResults(){
        System.out.println("Cars:\n");
        for (Car car: carList){
            System.out.printf("%s %s %n", car.name, car.distanceTraveled);
        }
        System.out.println("\nMotorcycles:\n");
        for (MotorCycle bike: bikeList){
            System.out.printf("%s %s %n", bike.name, bike.distanceTraveled);
        }
        System.out.println("\nTrucks:\n");
        for (Truck truck: truckList){
            System.out.printf("%s %s %n", truck.name, truck.distanceTraveled);
        }
    }

    public static void main(String[] args) {
        Main race = new Main();
        race.createVehicles();
        race.simulateRace();
        race.printRaceResults();
    }
}
