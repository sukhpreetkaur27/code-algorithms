package com.code.files.io;

import java.io.Serializable;

public class _0_Animal implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;
  private int age;
  private char type;

  /**
   * To be skipped during serialization
   * 
   * if object is printed after de-serialization --> default values are printed,
   * i.e., for Objects = null, for primitives = default value
   */
  private transient String check;

  public _0_Animal(String name, int age, char type) {
    this.name = name;
    this.age = age;
    this.type = type;
    this.setCheck("I'm transient");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public char getType() {
    return type;
  }

  public void setType(char type) {
    this.type = type;
  }

  public String getCheck() {
    return check;
  }

  public void setCheck(String check) {
    this.check = check;
  }

  @Override
  public String toString() {
    return "_0_Animal [name=" + name + ", age=" + age + ", type=" + type + ", check="
        + check + "]";
  }

}
