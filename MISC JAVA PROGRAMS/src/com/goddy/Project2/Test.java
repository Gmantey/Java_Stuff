package com.goddy.Project2;

public class Test {

    public static void main(String [] args) {

        System.out.println("Car Getter and Setter Tests");

        Car car = new Car();
        CarRentalAgency methods = new CarRentalAgency();

        car.setType(Classification.SUV);
        car.setMaxSeating(5);
        car.setTowingCapacity(1000);
        car.setFuelEconomy(29.2);
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setVin("123advasdv122");
        car.setPurchasePrice(30000.33);
        car.setMileage(10000);


        System.out.println("Type: " + car.getType());
        System.out.println("Max Seating: " + car.getMaxSeating());
        System.out.println("Towing capacity: " + car.getTowingCapacity());
        System.out.printf("Fuel Economy: %.2f\n", car.getFuelEconomy());
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Vin: " + car.getVin());
        System.out.printf("Purchase Price: %.2f\n", car.getPurchasePrice());
        System.out.println("Mileage: " + car.getMileage());
        methods.option1();

    }
}
