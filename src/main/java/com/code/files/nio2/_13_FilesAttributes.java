package com.code.files.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class _13_FilesAttributes {

  public static void main(String[] args) throws IOException {
    check();
    isHidden();
    readExec();
    size();
    time();
    owner();
  }

  private static void check() {
    /**
     * do not throw an exception if file or directory doesn't exists
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");

    System.out.println(Files.isDirectory(src));
    System.out.println(Files.isRegularFile(src));
    System.out.println(Files.isSymbolicLink(src));

    if (Files.isDirectory(src)) {
      /**
       * no need to write
       * 
       * if (Files.exists(src) && Files.isDirectory(src))
       * 
       * as Files.isDirectory(src) -> do not throw an exception if the file doesn't
       * exists
       */
    }
  }

  private static void isHidden() throws IOException {
    /**
     * Hidden files are marked with . in Linux
     * 
     * for Windows, hidden attribute is set
     */
    /**
     * throws an exception due to I/O error while reading file metadata
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(Files.isHidden(src));
  }

  private static void readExec() {
    /**
     * do not throw an exception if file or directory doesn't exists
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");

    System.out.println(Files.isReadable(src));
    System.out.println(Files.isExecutable(src));
  }

  private static void size() throws IOException {
    /**
     * Only for files
     * 
     * Calling Files.size() on a directory is system dependent and undefined.
     */
    /**
     * throws an exception if file doesn't exists or due to I/O error while reading
     * file metadata
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(Files.size(src));
  }

  private static void time() throws IOException {
    /**
     * throws an exception if file doesn't exists or due to I/O error while reading
     * file metadata
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(Files.getLastModifiedTime(src).toMillis());

    Files.setLastModifiedTime(src, FileTime.fromMillis(System.currentTimeMillis()));
  }

  private static void owner() throws IOException {
    /**
     * throws an exception if file doesn't exists or due to I/O error while reading
     * file metadata
     */
    Path src = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    System.out.println(Files.getOwner(src).getName());

    /**
     * find principal or owner by name using default file system
     */
    UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService()
        .lookupPrincipalByName("kanwar");

    /**
     * find principal or owner by name using default file system via path
     */
    UserPrincipal owner1 = src.getFileSystem().getUserPrincipalLookupService()
        .lookupPrincipalByName("kanwar");

    Files.setOwner(src, owner1);
  }

}
