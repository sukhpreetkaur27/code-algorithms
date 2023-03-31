package com.code.files.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class _8_ObjectIOStream {

  public static void main(String[] args) {
    File input = new File("/Users/sukh/resume/copy_test/Animals.data");
    File output = new File("/Users/sukh/resume/copy_test/Animals.data");
    process(input, output);
  }

  private static void process(File input, File output) {
    List<_0_Animal> animals = input();
    write(animals, output);
    List<_0_Animal> readData = read(input);
    System.out.println(readData);
  }

  private static List<_0_Animal> read(File input) {
    List<_0_Animal> animals = new ArrayList<>();
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(input)))) {
      /**
       * No check to reach EoF --> throws EOFException
       */
      while (true) {
        /**
         * throws checked ClassNotFoundException
         */
        Object obj = in.readObject();
        /**
         * checks for incompatible classes and null objects
         */
        if (obj instanceof _0_Animal) {
          _0_Animal animal = (_0_Animal) obj;
          animals.add(animal);
        }
      }
    } catch (EOFException e) {
      /**
       * EoF reached
       */
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
    return animals;
  }

  private static void write(List<_0_Animal> animals, File output) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(output)))) {
      for (_0_Animal animal : animals) {
        out.writeObject(animal);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static List<_0_Animal> input() {
    List<_0_Animal> animals = new ArrayList<>();
    animals.add(new _0_Animal("Sukh", 30, 'W'));
    animals.add(new _0_Animal("KP", 29, 'M'));
    return animals;
  }
}
