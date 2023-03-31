package com.code.algos.striver.dp;

public class _61_RaceCar {

  public int racecar(int target) {
    if (target == 1) {
      return 1;
    }
    return racecar(0, 1, target);
  }

  private int racecar(int position, int speed, int target) {
    if (position == target) {
      return 0;
    }
    if (position > target) {
      return Integer.MAX_VALUE;
    }
    int acc_steps = Integer.MAX_VALUE;
    if (speed > 0 && position + speed <= target) {
      acc_steps = racecar(position + speed, speed * 2, target);
      if (acc_steps != Integer.MAX_VALUE) {
        acc_steps++;
      }
    }

    int rev_steps = Integer.MAX_VALUE;
    if (position >= 0) {
      if (speed > 0) {
        rev_steps = racecar(position, speed - 1, target);
      } else {
        rev_steps = racecar(position, 1, target);
      }
      if (rev_steps != Integer.MAX_VALUE) {
        rev_steps++;
      }
    }

    return Math.min(acc_steps, rev_steps);
  }

  public static void main(String[] args) {
    _61_RaceCar obj = new _61_RaceCar();
    System.out.println(obj.racecar(3));
  }

}
