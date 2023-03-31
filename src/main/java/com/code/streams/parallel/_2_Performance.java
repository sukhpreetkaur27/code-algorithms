package com.code.streams.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _2_Performance {

  public static void main(String[] args) {
    _2_Performance obj = new _2_Performance();

    List<Integer> recordStream = Stream.iterate(1, n -> n + 1).limit(4000)
        .collect(Collectors.toList());

    List<Integer> records = new ArrayList<>();
    for (int i = 1; i <= 4000; i++) {
      records.add(i);
    }

    long start = System.currentTimeMillis();
    System.out.println("Start time: " + start / 1000.0);

    obj.processRecordsSerial(records);

    System.out.println(System.currentTimeMillis());
    long end = System.currentTimeMillis() - start;
    System.out.println("Serial End time: " + end / 1000.0);

    start = System.currentTimeMillis();
    System.out.println("Start time: " + start / 1000.0);

    obj.processRecordsParallel(records);

    System.out.println(System.currentTimeMillis());
    end = System.currentTimeMillis() - start;
    System.out.println("Parallel End time: " + end / 1000.0);
  }

  private void processRecordsSerial(List<Integer> records) {
    records.stream().map(a -> processRecord(a)).count();
  }

  private void processRecordsParallel(List<Integer> records) {
    records.parallelStream().map(a -> processRecord(a)).count();
  }

  private int processRecord(Integer a) {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      System.out.println("InterruptedException");
    }
    return a;
  }

}
