package com.code.files.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class _5_BufferedIOStream {

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
    try (InputStream in = new BufferedInputStream(new FileInputStream(input));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {
      byte[] buffer = new byte[1024];
      int length;
      /**
       * Read bytes of data from buffer
       * 
       * 0 == EoF
       */
      while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
        out.flush();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
