package com.code.files.nio2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _9_PathMethods {

  public static void main(String[] args) throws IOException {
    /**
     * Checks if file exists or not
     * 
     * supports Link options like NOFOLLOW_LINKS
     * 
     * works with sym links
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(path1.toRealPath());
  }

}
