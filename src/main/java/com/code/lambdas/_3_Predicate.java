package com.code.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _3_Predicate {

  public static void main(String[] args) {
    Predicate<String> predicate = String::isEmpty;
    System.out.println(predicate.test(""));

    BiPredicate<String, String> biPred = String::startsWith;
    System.out.println(biPred.test("Sukhpreet", "Sukh"));
  }

}
