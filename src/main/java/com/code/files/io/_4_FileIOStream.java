package com.code.files.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class _4_FileIOStream {

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
    try (InputStream fis = new FileInputStream(input);
        OutputStream fos = new FileOutputStream(output)) {
      int _byte;
      /**
       * Read 1 byte at a time
       * 
       * -1 == EoF
       */
      while ((_byte = fis.read()) != -1) {
        fos.write(_byte);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
