package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _4_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println("isAbsolute ? " + path1.isAbsolute());
    /**
     * if the Path object already represents an absolute path, then the output is a
     * new Path object with the same value
     */
    System.out.println("Absolute Path: " + path1.toAbsolutePath());

    Path path2 = Paths.get("resume/copy_test/sukh.txt");
    System.out.println("isAbsolute ? " + path2.isAbsolute());
    /**
     * converts a relative Path object to an absolute Path object by joining it to
     * the current working directory
     */
    System.out.println("Absolute Path: " + path2.toAbsolutePath());
  }

}
