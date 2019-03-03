package com.melnyk.rw;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Writer {

  public void writeWithBuffer(int bufferSize) {
    try (BufferedReader reader = new BufferedReader(new FileReader("12.pdf"));
        BufferedOutputStream buffer = new BufferedOutputStream(
            new FileOutputStream("MyFile.txt"), bufferSize * 1048576)) {
      long startTime = System.currentTimeMillis();
      while (reader.ready()) {
        buffer.write(reader.read());
      }
      System.out.println("Time of writing with buffer with size "
          + bufferSize + "MB = " + ((new Date()).getTime() - startTime) + "ms");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeWithoutBuffer() {
    try (BufferedReader reader = new BufferedReader(new FileReader("12.pdf"));
        FileOutputStream file = new FileOutputStream("MyFile.txt")) {
      long startTime = System.currentTimeMillis();
      while (reader.ready()) {
        file.write(reader.read());
      }
      System.out.println("Time of writing without buffer = "
          + ((new Date()).getTime() - startTime) + "ms");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
