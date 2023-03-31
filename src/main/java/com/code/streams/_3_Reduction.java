package com.code.streams;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class _3_Reduction {

  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("s", "u", "k", "h");
    /**
     * T reduce(T identity, BinaryOperator<T> accumulator)
     */
    String r1 = s1.reduce("", String::concat);
    System.out.println(r1);

    Stream<Integer> s2 = Stream.of(1, 2, 3);
    Integer ans = s2.reduce(1, (a, b) -> a * b);
    System.out.println(ans);

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator)
     */
    Stream<String> s3 = Stream.of("k", "a", "n", "w", "a", "r");
    Optional<String> ans_s3 = s3.reduce(String::concat);
    ans_s3.ifPresent(System.out::println);

    /**
     * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator,
     * BinaryOperator<U> combiner)
     */
    Stream<Integer> nums = Stream.of(3, 5, 6);
    BinaryOperator<Integer> mul = (a, b) -> a * b;
    System.out.println(nums.reduce(1, mul, mul));
  }

}
