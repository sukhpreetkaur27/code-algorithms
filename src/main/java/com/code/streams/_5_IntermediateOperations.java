package com.code.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class _5_IntermediateOperations {

  public static void main(String[] args) {
    /**
     * Stream<T> filter(Predicate<? super T> predicate)
     */
    Stream<String> s1 = Stream.of("monkey", "goriila", "chimp");
    Stream<String> s2 = s1.filter(s -> s.startsWith("m"));
    s2.forEach(System.out::println);

    Stream.of("sukh", "preet", "kaur").filter(s -> s.length() > 4)
        .forEach(System.out::println);

    /**
     * Stream<T> distinct()
     */
    Stream.of(1, 2, 1, 1, 4, 5, 6, 2).distinct().forEach(System.out::print);

    System.out.println();

    /**
     * Stream<T> limit(int maxSize)
     * 
     * Stream<T> skip(int numOfElements)
     */
    Stream.iterate(1, n -> n + 1).skip(5).limit(2).forEach(System.out::print);

    System.out.println();

    /**
     * Stream<R> map(Function<? super T, ? extends R> mapper)
     */
    Stream.of("sukh", "preet", "kaur").map(a -> a.length()).forEach(System.out::print);
    Stream.of("sukh", "preet", "kaur").map(String::length).forEach(System.out::print);

    System.out.println();

    /**
     * flatMap(Function<> mappper)
     * 
     * remove empty elements from a stream (or) merge a stream of lists
     */
    List<String> zero = Arrays.asList();
    List<String> one = Arrays.asList("sukh");
    List<String> two = Arrays.asList("kp", "kanwar");
    Stream<List<String>> all = Stream.of(zero, one, two);
    all.flatMap(l -> l.stream()).forEach(System.out::println);

    /**
     * Stream<T> sorted()
     * 
     * Stream<T> sorted(Comparator<T>)
     */
    Stream.of(56, 22, 35, 8).sorted().forEach(System.out::println);
    Stream.of(56, 22, 35, 8).sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
    /**
     * The type Comparator does not define reverseOrder(Integer, Integer) that is
     * applicable here
     * 
     * Stream.of(56, 22, 35, 8).sorted(Comparator::reverseOrder)
     * .forEach(System.out::println);
     */

    /**
     * Stream<T> peek(Consumer<T> action)
     * 
     * for debugging
     */
    long count = Stream.of("black bear", "grizzly", "brown bear")
        .filter(s -> s.startsWith("g")).peek(System.out::println).count();
    System.out.println(count);
  }

}
