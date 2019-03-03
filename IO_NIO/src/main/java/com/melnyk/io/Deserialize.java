package com.melnyk.io;

import com.melnyk.laptops.Laptop;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserialize {

  public static void deserialize() {
    List<Laptop> laptops;
    try (ObjectInputStream input = new ObjectInputStream(
        new FileInputStream("myLaptops.txt"))) {
      laptops = (List<Laptop>) input.readObject();
      laptops.forEach(System.out::println);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
