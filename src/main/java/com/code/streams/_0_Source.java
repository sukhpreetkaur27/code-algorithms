package com.code.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _0_Source {

  public static void main(String[] args) {
    Stream<String> empty = Stream.empty();
    Stream<String> single = Stream.of("Sukh");
    Stream<String> array = Stream.of("Sukh", "KP", "Kanwar");

    System.out.println(empty.count());
    System.out.println(single.count());
    System.out.println(array.count());

    List<String> list = Arrays.asList("Sukh", "KP", "Kanwar");
    Stream<String> serial = list.stream();
    Stream<String> parallel = list.parallelStream();

    System.out.println(serial.count());
    System.out.println(parallel.count());
  }

}
