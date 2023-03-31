package com.code.streams.parallel;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3_Collect {

  public static void main(String[] args) {
    /**
     * Use Concurrent classes to achieve parallel reduction, i.e., no loss of values
     * or other synchronization issues
     */
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Set<String> p1 = s1.parallel().collect(ConcurrentSkipListSet::new, Set::add,
        Set::addAll);
    System.out.println(p1);
    System.out.println(p1.getClass());

    /**
     * Collector should have 2 characteristics: UNORDERED and CONCURRENT
     * 
     * 1. toConcurrentMap
     * 
     * 2. groupuingByConcurrent
     */
    Stream<String> s2 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    ConcurrentMap<Integer, String> p2 = s2.parallel().collect(
        Collectors.toConcurrentMap(String::length, s -> s, (a, b) -> a + ", " + b));
    System.out.println(p2);
    System.out.println(p2.getClass());

    Stream<String> s3 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    ConcurrentMap<Integer, List<String>> p3 = s3.parallel()
        .collect(Collectors.groupingByConcurrent(String::length));
    System.out.println(p3);
    System.out.println(p3.getClass());
    System.out.println(p3.get(2).getClass());
  }

}
