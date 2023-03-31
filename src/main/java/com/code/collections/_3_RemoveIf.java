package com.code.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3_RemoveIf {

  public static void main(String[] args) {
    /**
     * Returns a fixed-size list backed by the specified array. Changes made to the
     * array will be visible in the returned list, and changes made to the list will
     * be visible in the array. The returned list is Serializable and implements
     * RandomAccess.
     * 
     * The returned list implements the optional Collection methods, except those
     * that would change the size of the returned list. Those methods leave the list
     * unchanged and throw UnsupportedOperationException.
     * 
     * List<String> list = Arrays.asList("sukh", "kp", "grewal");
     * 
     * list.removeIf(s -> s.startsWith("k"));
     */
    List<String> list = new ArrayList<>(Arrays.asList("sukh", "kp", "grewal"));
    list.removeIf(s -> s.startsWith("k"));
    System.out.println(list);
  }

}
