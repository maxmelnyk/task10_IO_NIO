package com.melnyk.task6;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

  private Map<String, String> mapMenu = new LinkedHashMap<>();
  private Map<String, Printable> mapMethods = new LinkedHashMap<>();

  public void menu() {
    MyTotalCommander commander = new MyTotalCommander();
    commander.setDirectory();

    mapMenu.put("1.", "Set directory");
    mapMenu.put("2.", "Show directory");
    mapMenu.put("3.", "Show directory size");
    mapMenu.put("4.", "Exit");

    mapMethods.put("1", commander::setDirectory);
    mapMethods.put("2", commander::showDirectory);
    mapMethods.put("3", commander::showDirectorySize);
    mapMethods.put("4", commander::exit);

    show();
  }

  private void show() {
    Scanner choice = new Scanner(System.in);
    String menuItem;
    for (; ; ) {
      System.out.println();
      mapMenu.forEach((k, v) -> System.out.println(k + v));
      System.out.println("Press your choice:");
      menuItem = choice.nextLine();
      try {
        mapMethods.get(menuItem).print();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
