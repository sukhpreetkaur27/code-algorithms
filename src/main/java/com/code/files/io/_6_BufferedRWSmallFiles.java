package com.code.files.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _6_BufferedRWSmallFiles {

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
    List<String> dataRead = read(input);
    write(dataRead, output);
  }

  private static List<String> read(File input) {
    /**
     * OK for small files for the data to be kept in memory while writing
     */
    List<String> dataRead = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
      String line;
      /**
       * uses new line as the delimiter
       */
      while ((line = reader.readLine()) != null) {
        dataRead.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dataRead;
  }

  private static void write(List<String> input, File output) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
      for (String data : input) {
        writer.write(data);
        /**
         * adds a new line to the file
         * 
         * required as line = reader.readLine(); used new line as the delimiter
         */
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
