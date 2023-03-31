package com.code.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class _2_TerminalOperations {

  public static void main(String[] args) {
    List<String> strings = Arrays.asList("sukh", "abc", "kp");
    Optional<String> min = strings.stream().min((s1, s2) -> s1.compareTo(s2));
    min.ifPresent(System.out::println);

    Optional<?> no = Stream.empty().min((a, b) -> 0);

    Optional<String> max = strings.stream().min((s1, s2) -> s2.compareTo(s1));
    max.ifPresent(System.out::println);

    Stream<String> finite = Stream.of("sukh", "kanwar", "kp");
    Stream<String> infinite = Stream.generate(() -> "grewal");

    Optional<String> findAnyF = finite.findAny();
    findAnyF.ifPresent(System.out::println);

    Optional<String> findaAnyI = infinite.findAny();
    System.out.println(findaAnyI.isPresent());

    List<String> list = Arrays.asList("sukh", "2", "kp");
    Predicate<String> match = x -> Character.isLetter(x.charAt(0));

    System.out.println(list.stream().allMatch(match));
    System.out.println(list.stream().anyMatch(match));
    System.out.println(list.stream().noneMatch(match));

    /**
     * Exception in thread "main" java.lang.IllegalStateException: stream has
     * already been operated upon or closed at
     * java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
     * at
     * java.base/java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:632)
     * at com.code.streams._2_TerminalOperations.main(_2_TerminalOperations.java:37)
     */
    // System.out.println(infinite.anyMatch(match));

    Stream<String> infy = Stream.generate(() -> "gg");
    System.out.println(infy.anyMatch(match));

    /**
     * Hangs the system
     */
    // System.out.println(Stream.generate(() -> "gg").allMatch(match));
    // System.out.println(Stream.generate(() -> "gg").noneMatch(match));

    Stream.of("sukh", "kp").forEach(System.out::println);
  }

}
