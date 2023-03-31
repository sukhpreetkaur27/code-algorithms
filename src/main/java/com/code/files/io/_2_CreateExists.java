package com.code.files.io;

import java.io.File;

public class _2_CreateExists {

  public static void main(String[] args) {
    /**
     * directory or file path
     */
    final String path = "/Users/sukh/resume/Binance";
    File file = new File(path);
    System.out.println(file.exists());

    final String parent = "/Users/sukh";
    final String child = "resume/Binance";
    File f2 = new File(parent, child);
    System.out.println(f2.exists());

    final String parent1 = null;
    final String child1 = "resume/Binance";
    /**
     * if parent = null or doesn't exists -> it reverts to the above single ctr
     */
    File f3 = new File(parent1, child1);
    System.out.println(f3.exists());
  }

}
