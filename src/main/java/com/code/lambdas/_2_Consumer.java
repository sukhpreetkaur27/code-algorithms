package com.code.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _2_Consumer {

  public static void main(String[] args) {
    Consumer<Integer> cons = System.out::println;
    cons.accept(20);

    Map<Integer, String> map = new HashMap<>();
    BiConsumer<Integer, String> bi = map::put;
    bi.accept(2, "Sukh");

    System.out.println(map);
  }

}
