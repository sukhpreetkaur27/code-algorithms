package com.code.files.nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderNotFoundException;

public class _1_Path {

  public static void main(String[] args) {
    path();
    fileSystem();
    legacy();
  }

  private static void path() {
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");

    Path path2 = Paths.get("/", "Users", "sukh", "resume", "copy_test", "sukh.txt");

    try {
      /**
       * throws exception -> as URI expects an absolute path
       * 
       * Exception in thread "main" java.lang.IllegalArgumentException: URI has an
       * authority component
       * 
       * schema = file:// (or) https:// (or) http:// (or) ftp://
       */
      /**
       * missing the root directory /
       */
      Path path3 = Paths.get(new URI("file://Users/sukh/resume/copy_test/sukh.txt"));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      Path path4 = Paths.get(new URI("file:///Users/sukh/resume/copy_test/sukh.txt"));
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    Path path5 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    /**
     * file:///Users/sukh/resume/copy_test/sukh.txt
     */
    URI uri5 = path5.toUri();
    System.out.println("URI: " + uri5);
  }

  private static void fileSystem() {
    Path path1 = FileSystems.getDefault()
        .getPath("/Users/sukh/resume/copy_test/sukh.txt");

    Path path2 = FileSystems.getDefault().getPath("/", "Users", "sukh", "resume",
        "copy_test", "sukh.txt");

    try {
      /**
       * 
       * FileSystems factory class does give us the ability to connect to a remote
       * file system,
       */
      FileSystem fileSystem = FileSystems
          .getFileSystem(new URI("http://www.selikoff.net"));

      Path path3 = fileSystem.getPath("duck.txt");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (ProviderNotFoundException e) {
      /**
       * Exception in thread "main" java.nio.file.ProviderNotFoundException: Provider
       * "http" not found
       */
      e.printStackTrace();
    }
  }

  private static void legacy() {
    Path path1 = Paths.get("/Users/sukh/resume/copy_test/sukh.txt");
    File file1 = path1.toFile();

    File file2 = new File("/Users/sukh/resume/copy_test/sukh.txt");
    Path path2 = file2.toPath();
  }

}
