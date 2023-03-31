package com.code.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _5_Function {

  public static void main(String[] args) {
    Function<String, Integer> length = String::length;
    System.out.println(length.apply("sukh"));

    BiFunction<String, String, String> concat = String::concat;
    System.out.println(concat.apply("Sukh", "Kanwar"));
  }

}
