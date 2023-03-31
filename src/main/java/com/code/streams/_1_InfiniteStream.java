package com.code.streams;

import java.util.stream.Stream;

public class _1_InfiniteStream {

  public static void main(String[] args) {
    Stream<Double> randoms = Stream.generate(Math::random); // Supplier
    Stream<Integer> odds = Stream.iterate(1, n -> n + 2); // Seed, UnaryOperator

    randoms.forEach(System.out::println); // terminal operation -> Consumer
    odds.forEach(System.out::println);
  }

}
