package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _5_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(path1);

    /**
     * total 5 elements
     */
    System.out.println("subpath(0, 5): " + path1.subpath(0, 5));
    System.out.println("subpath(1, 5): " + path1.subpath(1, 5));
    System.out.println("subpath(2, 5): " + path1.subpath(2, 5));
    System.out.println("subpath(3, 5): " + path1.subpath(3, 5));
    System.out.println("subpath(4, 5): " + path1.subpath(4, 5));

    /**
     * throws java.lang.IllegalArgumentException
     */
    System.out.println("subpath(0, 5): " + path1.subpath(0, 0));
    System.out.println("subpath(0, 5): " + path1.subpath(5, 5));
  }

}
