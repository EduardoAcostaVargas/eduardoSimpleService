package org.example.eduardosimpleservice;

public class Shoe {
    private int id;
    private String model;
    private String brand;
    private double shoeSize;
    private double price;

    public Shoe(){

    }

    public Shoe(int id, String brand, String model,double shoeSize, double price){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.shoeSize = shoeSize;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }
}
