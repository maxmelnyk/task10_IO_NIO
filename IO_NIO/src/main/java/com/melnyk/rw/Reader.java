package com.melnyk.rw;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Reader {

  public void readWithoutBuffer() {
    try (FileInputStream fileInputStream = new FileInputStream("123.pdf")) {
      long startTime = System.currentTimeMillis();
      while (fileInputStream.read() != -1) {
        fileInputStream.read();
      }
      System.out.println("Time of reading without buffer = "
          + ((new Date()).getTime() - startTime) + "ms");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readWithBuffer(int bufferSize) {
    try (BufferedInputStream buffer = new BufferedInputStream(
        new FileInputStream("123.pdf"), bufferSize * 1048576)) {
      long startTime = System.currentTimeMillis();
      while (buffer.read() != -1) {
        buffer.read();
      }
      System.out.println("Time of reading with buffer with size "
          + bufferSize + "MB = " + ((new Date()).getTime() - startTime) + "ms");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readOnlyComments() {
    String findComments;
    Scanner fileName = new Scanner(System.in);

    System.out.println("Enter file name:");
    String name = fileName.nextLine();

    try (BufferedReader buffer = new BufferedReader(new FileReader(name))) {
      while (buffer.ready()) {
        findComments = buffer.readLine();
        if (findComments.startsWith("//")) {
          System.out.println(findComments + "\n");
        }
        if (findComments.startsWith("/*") || findComments.startsWith("  /*")
            || findComments.startsWith("    /*")) {
          System.out.println(findComments);
          while (!findComments.endsWith("*/")) {
            findComments = buffer.readLine();
            System.out.println(findComments);
          }
          System.out.println();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
