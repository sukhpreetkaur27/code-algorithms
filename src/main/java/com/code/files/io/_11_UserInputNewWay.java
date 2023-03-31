package com.code.files.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class _11_UserInputNewWay {

  public static void main(String[] args) throws IOException {
    /**
     * Singleton class; means that there is only one version of the object available
     * in the JVM
     */
    Console console = System.console();
    /**
     * will return null in environments where text interactions are not supported.
     */
    if (console != null) {
      flushReadLine(console);
      format(console);
      readPassword(console);
    }
  }

  private static void readPassword(Console console) {
    char[] pswd = console.readPassword("Enter password: ");
    console.format("Re-enter password: ");
    console.flush();
    char[] verify = console.readPassword();

    boolean match = Arrays.equals(pswd, verify);

    /**
     * Immediately clear passwords from memory
     */
    Arrays.fill(pswd, 'X');
    Arrays.fill(verify, 'X');

    console.writer().println("Password " + (match ? "correct" : "incorrect"));
  }

  private static void flushReadLine(Console console) throws IOException {
    console.writer().print("Enter input");
    console.flush();
    String userInput = console.readLine();
    console.writer().println("you have entered: " + userInput);

    String name = console.readLine("Please enter your name: ");

    Integer age = null;
    console.writer().print("Enter age: ");
    console.flush();
    BufferedReader reader = new BufferedReader(console.reader());
    String value = reader.readLine();
    age = Integer.valueOf(value);
    console.writer().println();

    console.format("Name: " + name);
    console.writer().println();
    console.printf("Age: " + age);
  }

  private static void format(Console console) {
    console.format("Our zoo has 391 animals and employs 25 people.");
    console.writer().println();
    console.printf("The zoo spans 128.91 acres");
  }

}
