package com.code.lambdas;

import java.util.function.Predicate;

public class _4_PredicateDefaultMethods {

  public static void main(String[] args) {
    Predicate<String> egg = s -> s.contains("egg");
    Predicate<String> brown = s -> s.contains("brown");

    Predicate<String> brownEggs = egg.and(brown);
    Predicate<String> otherEggs = egg.and(brown.negate());
  }

}
