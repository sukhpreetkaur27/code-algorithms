package com.code.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _13_Partitioning {

  public static void main(String[] args) {
    /**
     * Returns: Map<Boolean, List<T>>
     */
    /**
     * partitioningBy(Predicate f)
     */
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Map<Boolean, List<String>> m1 = s1
        .collect(Collectors.partitioningBy(s -> s.length() <= 5));
    System.out.println(m1);

    /**
     * partitioningBy(Predicate f, Collector c)
     */
    Stream<String> s2 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Map<Boolean, Set<String>> m2 = s2
        .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.toSet()));
    System.out.println(m2);

    Stream<String> s3 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Map<Boolean, Long> m3 = s3
        .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.counting()));
    System.out.println(m3);
  }

}
