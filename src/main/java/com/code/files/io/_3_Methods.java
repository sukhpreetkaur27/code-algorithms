package com.code.files.io;

import java.io.File;
import java.util.Arrays;

public class _3_Methods {

  public static void main(String[] args) {
    /**
     * directory or file path
     */
    final String path = "/Users/sukh/resume/Binance/Sukhpreet Kaur Grewal - Cover Letter.docx";
    File file = new File(path);

    /**
     * the name of the file or directory with extension
     */
    System.out.println("file.getName(): " + file.getName());

    /**
     * absolute path name (inclusive of the file name)
     */
    System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());

    /**
     * check for directory
     */
    System.out.println("file.isDirectory(): " + file.isDirectory());

    /**
     * check for file
     */
    System.out.println("file.isFile(): " + file.isFile());

    /**
     * size of the file or directory -> # of bytes
     */
    System.out.println("file.length(): " + file.length());

    /**
     * # of milliseconds since epoch the file or directory was last modified
     */
    System.out.println("file.lastModified(): " + file.lastModified());

    /**
     * deletes the file or directory
     */
    // System.out.println("file.delete(): " + file.delete());

    /**
     * Renames the file or directory
     */
    // System.out.println("file.renameTo(): " + file.renameTo(new File("renamed")));

    File dir = new File("/Users/sukh/Downloads/Test/test.txt");
    /**
     * creates a directory -> returns true or false based on success
     */
    System.out.println("file.mkdir(): " + dir.mkdir());

    /**
     * creates a directory (including any non-existent parent directories) ->
     * returns true or false based on success
     */
    System.out.println("file.mkdirs(): " + dir.mkdirs());

    /**
     * get the parent path of the file or directory
     */
    System.out.println("file.getParent(): " + dir.getParent());

    File file1 = new File("/Users/sukh/resume/Binance");
    /**
     * Return list of files in the directory
     * 
     * NullPointerException -> if path is not directory
     */
    File[] files = file1.listFiles();
    Arrays.asList(files).stream().forEach(System.out::println);
  }

}
