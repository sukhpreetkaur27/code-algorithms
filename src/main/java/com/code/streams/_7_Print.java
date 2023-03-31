package com.code.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _7_Print {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("sukh", "kp", "kanwar");

    list.stream().forEach(System.out::println);

    list.stream().peek(System.out::println).count();

    System.out.println(list.stream().collect(Collectors.toList()));

    /**
     * Infinite streams
     */
    list.stream().limit(5).forEach(System.out::println);
  }

}
