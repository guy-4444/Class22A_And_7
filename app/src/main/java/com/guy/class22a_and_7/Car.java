package com.guy.class22a_and_7;

public class Car {
    private String model = "";
    private String license = "";
    private double fuel = 0.0;
    private int year = 0;
    private boolean manual = false;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getLicense() {
        return license;
    }

    public Car setLicense(String license) {
        this.license = license;
        return this;
    }

    public double getFuel() {
        return fuel;
    }

    public Car setFuel(double fuel) {
        this.fuel = fuel;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Car setYear(int year) {
        this.year = year;
        return this;
    }

    public boolean isManual() {
        return manual;
    }

    public Car setManual(boolean manual) {
        this.manual = manual;
        return this;
    }
}
