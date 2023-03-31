package com.code.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class _0_Optional {

  public static void main(String[] args) {
    String value = "sukh";
    Optional<String> empty = Optional.empty();
    try {
      empty.get();
    } catch (NoSuchElementException e) {
      System.out.println("NoSuchElementException");
    }
    Optional<String> op = Optional.of(value);
    Optional<String> ofNull = Optional.ofNullable(value);

    if (op.isPresent()) {
      String res = ofNull.get();
    }
    op.ifPresent(System.out::println);

    op.orElse("Hi");
    op.orElseGet(() -> "Sukh");
    op.orElseThrow(() -> new NoSuchElementException());
    op.orElseThrow(NoSuchElementException::new);
  }

}
