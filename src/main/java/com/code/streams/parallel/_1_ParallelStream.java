package com.code.streams.parallel;

import java.util.Arrays;
import java.util.stream.Stream;

public class _1_ParallelStream {

  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Stream<String> p1 = s1.parallel();
    p1.forEach(s -> System.out.print(s + ", "));

    System.out.println();

    Stream<String> p2 = Arrays.asList("sukh", "kp", "kanwar", "sp", "gavy", "kp")
        .parallelStream();
    p2.forEachOrdered(s -> System.out.print(s + ", "));
  }

}
