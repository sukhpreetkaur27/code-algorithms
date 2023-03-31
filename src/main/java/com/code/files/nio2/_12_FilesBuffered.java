package com.code.files.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _12_FilesBuffered {

  public static void main(String[] args) throws IOException {
    read();
    write();
    readAllLines();
  }

  private static void read() throws IOException {
    /**
     * checks if file or directory actually exists or not
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    try (BufferedReader reader = Files.newBufferedReader(src, Charset.forName("UTF-8"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }

  private static void write() throws IOException {
    /**
     * creates a new file (or) overwrites it
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    try (BufferedWriter writer = Files.newBufferedWriter(src, Charset.forName("UTF-8"))) {
      writer.write("Sukh");
    }
  }

  private static void readAllLines() throws IOException {
    /**
     * checks if file or directory actually exists or not
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    /**
     * if the file is significantly large, you may encounter an OutOfMemoryError
     * trying to load all of it into memory.
     */
    List<String> lines = Files.readAllLines(src);
    for (String line : lines) {
      System.out.println(line);
    }
  }

}
