package com.code.files.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class _8_PathMethods {

  public static void main(String[] args) {
    /**
     * Doesn't checks if file exists or not
     * 
     * only concerned with the Path
     */
    /**
     * Absolute Paths
     */
    Path path1 = Paths.get("/Users/copy_test/sukh.txt");
    Path path2 = Paths.get("/Users/sukh/resume");
    
    Path relative = path1.relativize(path2);
    System.out.println("Relativize: " + relative);
    
    Path resolve = path1.resolve(relative);
    System.out.println(resolve);

    System.out.println(resolve.normalize());
  }

}
