package com.code.collections;

import java.util.ArrayList;
import java.util.List;

public class _0_List {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    try {
      /**
       * remove(int) doesn't autobox to its wrapper
       */
      System.out.println(list.remove(3)); // IndexOutOfBoundsException
    } catch (IndexOutOfBoundsException e) {
      System.out.println("IndexOutOfBoundsException");
    }
    /**
     * Use Integer.valueOf(int) over new Integer(int) as it yields better
     * performance results over the other --> caching
     */
    System.out.println(list.remove(Integer.valueOf(3)));

    List<String> strings = new ArrayList<>();
    strings.add("Sukh");
    strings.add(0, "KP");
    strings.set(1, "Sukhpreet");
    System.out.println(strings.get(0));
    System.out.println(strings.indexOf("KP"));
  }

}
