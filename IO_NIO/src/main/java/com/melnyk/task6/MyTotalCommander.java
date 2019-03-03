package com.melnyk.task6;

import java.io.File;
import java.util.Scanner;

public class MyTotalCommander {

  private File file;

  public void setDirectory() {
    System.out.println("Please print directory:");
    Scanner newDirectory = new Scanner(System.in);
    String directory = newDirectory.nextLine();
    file = new File(directory);
    while (!file.isDirectory()) {
      System.out.println("This directory doesn't exist.");
      setDirectory();
    }
  }

  public void showDirectory() {
    File[] files = file.listFiles();
    System.out.println(file.getPath());
    assert files != null;
    for (File oneFile : files) {
      if (oneFile.isDirectory()) {
        System.out.println(
            "Directory: " + oneFile.getName() + "\tSize: " + folderSize(
                oneFile));
      } else {
        System.out.println(
            "File: " + oneFile.getName() + "\tSize: " + oneFile.length());
      }
    }
  }

  private static long folderSize(File directory) {
    long length = 0;
    File[] files = directory.listFiles();
    assert files != null;
    for (File file : files) {
      if (file.isFile()) {
        length += file.length();
      } else {
        length += folderSize(file);
      }
    }
    return length;
  }

  public void showDirectorySize() {
    System.out.println("Directory size = " + folderSize(file) + " bites");
  }

  public void exit() {
    System.exit(0);
  }
}
