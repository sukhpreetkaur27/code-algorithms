package com.code.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _4_Collector {

  public static void main(String[] args) {
    /**
     * collect(Supplier s, BiConsumer accumulator, BiConsumer combiner)
     */
    Stream<String> s1 = Stream.of("w", "o", "l", "f");
    TreeSet<String> treeSet = s1.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
    System.out.println(treeSet);

    Stream<Integer> s2 = Stream.of(1, 2, 3);
    List<Integer> list = s2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    System.out.println(list);

    Stream<String> s3 = Stream.of("sukh", "preet", "kaur");
    StringBuilder sb = s3.collect(StringBuilder::new, StringBuilder::append,
        StringBuilder::append);
    System.out.println(sb.toString());

    Stream<String> s4 = Stream.of("kanwar", "sukh", "grewal");
    List<String> s4_list = s4.collect(Collectors.toCollection(ArrayList::new));
    System.out.println(s4_list);

    Stream<Integer> s5 = Stream.of(60, 30, 40);
    Set<Integer> s5_set = s5.collect(Collectors.toSet());
    System.out.println(s5_set);

    Stream<Integer> s6 = Stream.of(44, 33, 88, 1);
    Set<Integer> s6_set = s6.collect(Collectors.toCollection(TreeSet::new));
    System.out.println(s6_set);

    Stream<String> s7 = Stream.of("sukh", "kp", "kanwar");
    System.out.println(s7.collect(Collectors.joining(", ")));

    Stream<String> s8 = Stream.of("sukh", "kp", "kanwar");
    Double result = s8.collect(Collectors.averagingInt(String::length));
    System.out.println(result);
  }

}
