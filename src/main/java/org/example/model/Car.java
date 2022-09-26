package org.example.model;

import java.util.List;

public class Car {

    private Maker maker;
    private List<Wheel> wheels;
    private int price;

    public Car(Maker maker, List<Wheel> wheels, int price) {
        this.maker = maker;
        this.wheels = wheels;
        this.price = price;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maker=" + maker +
                ", wheels=" + wheels +
                ", price=" + price +
                '}';
    }
}
