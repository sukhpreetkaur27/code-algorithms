package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _2_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");

    /**
     * toString() is called
     */
    System.out.println(path1);

    /**
     * the components of the file excluding the root
     */
    for (int i = 0; i < path1.getNameCount(); i++) {
      /**
       * getName(int) method is zero-indexed, with the file system root excluded from
       * the path components
       */
      System.out.println("Component " + i + ": " + path1.getName(i));
    }
  }

}
