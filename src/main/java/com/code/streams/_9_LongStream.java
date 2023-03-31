package com.code.streams;

import java.util.stream.LongStream;

public class _9_LongStream {

  public static void main(String[] args) {
    LongStream longs = LongStream.range(0, 5);
    LongStream closed = LongStream.rangeClosed(0, 5);
    longs.forEach(System.out::println);
    closed.forEach(System.out::println);
  }

}
