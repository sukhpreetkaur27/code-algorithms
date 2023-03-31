package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _3_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    hierarchy(path1);

    Path path2 = Paths.get("resume/copy_test/sukh.txt");
    hierarchy(path2);
  }

  private static void hierarchy(Path path1) {
    /**
     * NOTE: all methods are relative to the PWD represented by the Path object
     * 
     * nothing goes beyond the Path object
     */
    /**
     * just the file name
     * 
     * the farthest from the root
     */
    System.out.println("Filename: " + path1.getFileName());

    /**
     * root
     * 
     * else null
     */
    System.out.println("Root: " + path1.getRoot());

    Path current = path1;
    /**
     * Goes till the Root
     */
    while ((current = current.getParent()) != null) {
      System.out.println("  Current Parent: " + current);
    }
  }

}
