package com.melnyk.io;

import com.melnyk.laptops.Laptop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serialize {

  public static void serialize(List<Laptop> myLaptops) {
    try (ObjectOutputStream output = new ObjectOutputStream(
        new FileOutputStream("myLaptops.txt"))) {
      output.writeObject(myLaptops);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
