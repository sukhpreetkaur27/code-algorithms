package com.code.threading.framework;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import org.apache.commons.math3.util.Precision;

public class _3_ForkJoinTask {

  public static void main(String[] args) {
    Double[] weights = new Double[10];
    ForkJoinTask<Double> task = new WeightAnimalTask(0, 10, weights);
    ForkJoinPool pool = new ForkJoinPool();
    Double sum = pool.invoke(task);

    System.out.println("Total sum = " + sum);
  }

}

class WeightAnimalTask extends RecursiveTask<Double> {

  private static final long serialVersionUID = -6440390954971803814L;
  private int start;
  private int end;
  Double[] weights;

  WeightAnimalTask(int start, int end, Double[] weights) {
    this.start = start;
    this.end = end;
    this.weights = weights;
  }

  @Override
  protected Double compute() {
    final int limit = 3;
    int entities = start - end;
    if (entities <= limit) {
      double weight, sum = 0;
      for (int i = start; i < end; i++) {
        weight = new Random().nextDouble(1, 100);
        weights[i] = Precision.round(weight, 2);
        sum += weights[i];
      }
      return sum;
    } else {
      int mid = start + (end - start) / 2;
      RecursiveTask<Double> task1 = new WeightAnimalTask(start, mid, weights);
      /**
       * Compute the [start, mid) in a separate thread
       */
      task1.fork();
      /**
       * compute the [mid, end) using current thread
       * 
       * wait for the task1 thread to compute its result
       */
      return new WeightAnimalTask(mid, end, weights).compute() + task1.join();
    }
  }

}
