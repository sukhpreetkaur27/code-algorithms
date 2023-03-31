package com.code.files.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _9_PrintWriter {

  public static void main(String[] args) {
    File source = new File("/Users/sukh/resume/copy_test/sukh.txt");
    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
      out.print("Name: ");
      out.println("Sukh");
      /**
       * format doesn't add a line break
       */
      out.format("Age: 30");
      out.println();
      out.printf("Bye");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
