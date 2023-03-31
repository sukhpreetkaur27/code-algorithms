package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _6_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     * 
     * only concerned with the Path
     */
    /**
     * Absolute Paths
     */
    Path path1 = Paths.get("/copy_test/sukh.txt");
    Path path2 = Paths.get("/Users/sukh/resume");
    System.out.println(path1.relativize(path2));
    System.out.println(path2.relativize(path1));

    /**
     * Relative Paths
     */
    Path path3 = Paths.get("resume/copy_test/sukh.txt");
    Path path4 = Paths.get("resume/copy_test/abc.txt");
    System.out.println(path3.relativize(path4));
    System.out.println(path4.relativize(path3));

    /**
     * Absolute-Relative Paths
     * 
     * throws java.lang.IllegalArgumentException: 'other' is different type of Path
     */
    Path path5 = Paths.get("/resume/copy_test/sukh.txt");
    Path path6 = Paths.get("resume/copy_test/abc.txt");
    System.out.println(path5.relativize(path6));
    System.out.println(path6.relativize(path5));
  }

}
