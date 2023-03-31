package com.code.streams;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _11_CollectorMap {

  public static void main(String[] args) {
    /**
     * Returns: Map<K, V>
     */
    /**
     * toMap(Function key, Function value)
     */
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar");
    Map<String, Integer> m1 = s1.collect(Collectors.toMap(s -> s, String::length));
    System.out.println(m1);

    Stream<String> s2 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    /**
     * Exception in thread "main" java.lang.IllegalStateException: Duplicate key 2
     * (attempted merging values kp and sp)
     * 
     * Map<Integer, String> m2 = s2.collect(Collectors.toMap(String::length, s ->
     * s));
     * 
     * It doesn't know how to handle duplicate keys as no merge function is defined
     */

    /**
     * toMap(Function key, Function value, BinaryOperator combiner)
     */
    Map<Integer, String> m2 = s2
        .collect(Collectors.toMap(String::length, s -> s, (a, b) -> a + "," + b));
    System.out.println(m2);

    /**
     * toMap(Function key, Function value, BinaryOperator combiner, Supplier
     * supplier)
     */
    Stream<String> s3 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    Map<Integer, String> m3 = s3.collect(
        Collectors.toMap(String::length, s -> s, (a, b) -> a + ", " + b, TreeMap::new));
    System.out.println(m3);
  }

}
