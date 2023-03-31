package com.code.threading.issues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _1_Deadlock {

  public static void main(String[] args) {
    Food food = new Food();
    Water water = new Water();

    Fox foxy = new Fox(food, water);
    Fox tails = new Fox(food, water);

    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(10);
      service.submit(() -> foxy.drinkAndEat());
      service.submit(() -> tails.eatAndDrink());
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}

class Food {

}

class Water {

}

class Fox {

  private Food food;
  private Water water;

  Fox(Food food, Water water) {
    this.food = food;
    this.water = water;
  }

  void eatAndDrink() {
    synchronized (food) {
      System.out.println("Got Food");
      move();
      synchronized (water) {
        System.out.println("Got Water");
      }
    }
  }

  void drinkAndEat() {
    synchronized (water) {
      System.out.println("Got Water");
      move();
      synchronized (food) {
        System.out.println("Got Food");
      }
    }
  }

  void move() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("InterruptedException");
    }
  }

}
