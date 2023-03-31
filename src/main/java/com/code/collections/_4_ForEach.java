package com.code.collections;

import java.util.Arrays;
import java.util.List;

public class _4_ForEach {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("sukh", "kp");
    list.forEach(System.out::println);
  }

}
