package com.melnyk.laptops;

import java.io.Serializable;

public class Laptop implements Serializable {

  private String maker;
  private String model;
  private int year;
  private transient int price;

  public Laptop(String maker, String model, int year, int price) {
    this.maker = maker;
    this.model = model;
    this.year = year;
    this.price = price;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Laptop{" +
        "maker='" + maker + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", price=" + price +
        '}';
  }
}
