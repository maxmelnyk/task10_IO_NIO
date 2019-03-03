package com.melnyk;

import com.melnyk.rw.SomeBuffer;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    SomeBuffer someBuffer = new SomeBuffer("newFile.txt");

    someBuffer.writeToFile("Hello, World!!!");
    someBuffer.readFromFile();
  }
}
