package com.guy.class22a_and_7;

import java.util.ArrayList;

public class Garage {

    private ArrayList<String> carsKeys = new ArrayList<>();

    public Garage() { }

    public ArrayList<String> getCarsKeys() {
        return carsKeys;
    }

    public Garage setCarsKeys(ArrayList<String> carsKeys) {
        this.carsKeys = carsKeys;
        return this;
    }
}
