package com.code.streams;

import java.util.stream.DoubleStream;

public class _10_DoubleStream {

  public static void main(String[] args) {
    DoubleStream rand = DoubleStream.generate(Math::random);
    rand.limit(5).forEach(System.out::println);
  }

}
