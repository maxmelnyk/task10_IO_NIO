package com.melnyk.laptops;

import java.util.ArrayList;
import java.util.List;

public class Shop {

  private List<Laptop> laptops = new ArrayList<>();

  public Shop() {
  }

  public void addProduct(Laptop laptop) {
    laptops.add(laptop);
  }

  public List<Laptop> getShopProducts() {
    return laptops;
  }
}
