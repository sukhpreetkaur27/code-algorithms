package com.code.files.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _7_BufferedRWLargeFiles {

  public static void main(String[] args) {
    File input = new File(
        "/Users/sukh/resume/Binance/Sukhpreet Kaur Grewal - Résumé.docx");
    /**
     * destination file name
     * 
     * even if it doesn't exists contents will be copied to it
     */
    File output = new File("/Users/sukh/resume/copy_test/copy.docx");
    copy(input, output);
  }

  private static void copy(File input, File output) {
    /**
     * OK for large files
     */
    try (BufferedReader reader = new BufferedReader(new FileReader(input));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
      char[] line = new char[1024];
      int length;
      /**
       * Read chars of data from buffer
       * 
       * 0 == EoF
       */
      while ((length = reader.read(line)) > 0) {
        writer.write(line, 0, length);
        writer.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
