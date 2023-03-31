package com.code.files.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10_UserInputOldWay {

  public static void main(String[] args) throws IOException {
    /**
     * we did not close the stream, as closing System.in would prevent our
     * application from accepting user input for the remainder of the application
     * execution.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    System.out.println("you have entered: " + input);
  }

}
