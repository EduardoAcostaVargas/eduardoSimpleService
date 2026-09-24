package org.example.eduardosimpleservice;

public class RunningGear {
    private int id;
    private String typeOfGear;
    private char size;
    private String color;
    private double price;

    public RunningGear(){}

    public RunningGear(int id, String typeOfGear, char size, String color, double price){
        this.id = id;
        this.typeOfGear = typeOfGear;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfGear() {
        return typeOfGear;
    }

    public void setTypeOfGear(String typeOfGear) {
        this.typeOfGear = typeOfGear;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
