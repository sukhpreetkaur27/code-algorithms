package com.code.files.nio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _10_Files {

  public static void main(String[] args) throws IOException {
    exists();
    isSameFile();
    directory();
    copy();
  }

  private static void exists() {
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    /**
     * checks if file or directory actually exists or not
     */
    System.out.println(Files.exists(path1));
  }

  private static void isSameFile() throws IOException {
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    Path path2 = path1;
    /**
     * same objects -> doesn't checks if file actually exists or not
     */
    System.out.println(Files.isSameFile(path1, path2));

    /**
     * for different objects --> checks if file actually exists or not
     * 
     * else -> java.nio.file.NoSuchFileException:
     */

    /**
     * . keeps the file path unchanged
     */
    Path path3 = Paths.get("/Users/sukh/resume/copy_test/./sukh.txt");
    Path path4 = Paths.get("/Users/sukh/resume/copy_test/./sukh.txt");
    System.out.println(Files.isSameFile(path3, path4));

    Path path5 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    /**
     * .. skips Binance
     */
    Path path6 = Paths.get("/Users/sukh/resume/Binance/../copy_test/./sukh.txt");
    System.out.println(Files.isSameFile(path5, path6));

  }

  private static void directory() throws IOException {
    /**
     * throws java.nio.file.FileAlreadyExistsException:
     * 
     * if file already exists
     */
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sample");
    Files.createDirectory(path1);

    Path path2 = Paths.get("/Users/sukh/resume/copy_test/sample/test1/test2");
    Files.createDirectories(path2);
  }

  private static void copy() throws IOException {
    /**
     * checks if file or directory actually exists or not
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    Path destn = Paths.get("/Users/sukh/resume/copy_test/sukh_copy.txt");

    /**
     * throws java.nio.file.FileAlreadyExistsException:
     * 
     * if file already exists
     */
    Files.copy(src, destn);

    try (InputStream in = new FileInputStream("/Users/sukh/resume/copy_test/sukh.txt");
        OutputStream out = new FileOutputStream(
            "/Users/sukh/resume/copy_test/sukh_copy_1.txt")) {
      /**
       * throws java.nio.file.FileAlreadyExistsException:
       * 
       * if file already exists
       */
      Files.copy(in, Paths.get("/Users/sukh/resume/copy_test/sukh_copy_3.txt"));
      Files.copy(Paths.get("/Users/sukh/resume/copy_test/sukh_copy_2.txt"), out);
    }
  }

}
