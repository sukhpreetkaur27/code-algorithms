package com.code.files.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class _11_Files {

  public static void main(String[] args) throws IOException {
    move();
  }

  private static void move() throws IOException {
    /**
     * checks if file or directory actually exists or not
     */
    /**
     * renames or moves (or) both
     */
    Path src_dir = Paths.get("/Users/sukh/resume/copy_test");
    Path destn_dir = Paths.get("/Users/sukh/resume/copy_test_rename");
    Files.move(src_dir, destn_dir, StandardCopyOption.REPLACE_EXISTING);

    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    Path destn = Paths.get("/Users/sukh/resume/copy_test/sukh_rename.txt");
    Files.move(src, destn, StandardCopyOption.REPLACE_EXISTING);
  }

  private static void delete() throws IOException {
    /**
     * checks if file or directory actually exists or not
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    Files.delete(src);

    Path destn = Paths.get("/Users/sukh/resume/copy_test/sukh_rename.txt");
    Files.deleteIfExists(destn);
  }

}
