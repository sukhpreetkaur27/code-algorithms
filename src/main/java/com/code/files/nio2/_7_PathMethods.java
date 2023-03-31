package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _7_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     * 
     * only concerned with the Path
     */
    /**
     * Absolute Path as input -> return the input
     */
    Path path1 = Paths.get("/copy_test/sukh.txt");
    Path path2 = Paths.get("/Users/sukh/resume");
    System.out.println(path1.resolve(path2));
    System.out.println(path2.resolve(path1));

    /**
     * Absolute-Relative Path as input -> return the input
     * 
     * deosn't clean up the .. options
     */
    Path path3 = Paths.get("/copy_test/../sukh.txt");
    Path path4 = Paths.get("Users/sukh/resume");
    System.out.println(path3.resolve(path4));
    
    Path path7 = Paths.get("/copy_test/sukh.txt");
    Path path8 = Paths.get("Users/sukh/resume");
    System.out.println(path7.resolve(path8));
    
    /**
     * Relative-Realtive
     */
    Path path5 = Paths.get("copy_test/../sukh.txt");
    Path path6 = Paths.get("Users/sukh/resume");
    System.out.println(path5.resolve(path6));
  }

}
