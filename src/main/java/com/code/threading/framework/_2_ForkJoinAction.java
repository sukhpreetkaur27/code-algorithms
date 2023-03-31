package com.code.threading.framework;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import org.apache.commons.math3.util.Precision;

public class _2_ForkJoinAction {

  public static void main(String[] args) {
    Double[] weights = new Double[10];

    ForkJoinTask<?> task = new WeightAnimalAction(weights, 0, 10);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(task);

    System.out.println("Weights : ");
    Arrays.asList(weights).stream().forEach(System.out::println);
  }

}

class WeightAnimalAction extends RecursiveAction {

  private static final long serialVersionUID = 8856543030598632667L;

  private Double[] weights;
  private int start;
  private int end;

  WeightAnimalAction(Double[] weights, int start, int end) {
    this.weights = weights;
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute() {
    final int limit = 3;
    int entities = end - start;

    if (entities <= limit) {
      /**
       * Task can be performed
       */
      Double weight = null;
      for (int i = start; i < end; i++) {
        weight = new Random().nextDouble(1, 100);
        weights[i] = Precision.round(weight, 2);
        System.out.println("weight: " + weights[i]);
      }
    } else {
      /**
       * Task needs to be spawned
       */
      int mid = start + (end - start) / 2;
      System.out.println("start: " + start + ", mid: " + mid + ", end: " + end);
      invokeAll(new WeightAnimalAction(weights, start, mid),
          new WeightAnimalAction(weights, mid, end));
    }
  }

}
