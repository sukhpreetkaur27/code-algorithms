package com.code.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class _6_Operators {

  public static void main(String[] args) {
    UnaryOperator<String> upper = String::toUpperCase;
    System.out.println(upper.apply("sukh"));

    BinaryOperator<String> concat = String::concat;
    System.out.println(concat.apply("sukh", "kp"));
  }

}
