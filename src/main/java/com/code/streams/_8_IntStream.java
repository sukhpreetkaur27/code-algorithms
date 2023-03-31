package com.code.streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class _8_IntStream {

  public static void main(String[] args) {
    IntStream stream = IntStream.of(1, 2, 3, 4, 5);
    System.out.println(stream.sum());

    IntStream stream1 = IntStream.of(1, 2, 3, 4, 5);
    OptionalDouble op = stream1.average();
    op.ifPresent(System.out::println);
  }

}
