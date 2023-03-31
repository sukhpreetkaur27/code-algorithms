package com.code.lambdas;

import java.util.function.Supplier;

public class _1_Supplier {

  public static void main(String[] args) {
    Supplier<StringBuilder> supp = StringBuilder::new;
    StringBuilder s = supp.get();
    s.append("hi");
    System.out.println(s.toString());
  }

}
