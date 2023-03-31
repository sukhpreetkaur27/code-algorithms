package com.code.files.io;

import java.io.File;

public class _1_Separator {

  public static void main(String[] args) {
    final String ppty = "file.separator";
    System.out.println(System.getProperty(ppty));
    System.out.println(File.separator);
  }

}
