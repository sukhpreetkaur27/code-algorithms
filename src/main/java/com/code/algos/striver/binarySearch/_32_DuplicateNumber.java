package com.code.algos.striver.binarySearch;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 * 
 * @author sukh
 *
 */
public class _32_DuplicateNumber {

  /**
   * Time: O(n log n) <br>
   * Space: O(1)
   * @param nums
   * @return
   */
  public int duplicate(int[] nums) {
    /**
     * nums contain n + 1 integers where each integer is in the range [1, n]
     * inclusive.
     */
    int lo = 1;
    int hi = nums.length - 1;
    int mid, ans = 0;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      if (isPossible(mid, nums)) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }

  /**
   * Consider an array that has nn distinct numbers in the range [1,n][1,n]. For
   * example: [1,2,3,4,5][1,2,3,4,5]. If we pick any one of these 5 numbers and
   * count how many numbers are less than or equal to it, the answer will be equal
   * to that number. So in [1,2,3,4,5][1,2,3,4,5], if you pick the number 44,
   * there's exactly 4 numbers that are less than or equal to 44. If you pick 33,
   * there's exactly 3 numbers that are less than or equal to 33, and so on.
   * However, when you have duplicates in the array, this count will exceed the
   * number at some point. For example: in [4,3,4,5,2,4,1][4,3,4,5,2,4,1], 33 has
   * 3 numbers less than or equal to it. However, the duplicate number will have a
   * count of numbers less than or equal to itself, that is greater than itself
   * (in this example, 44, which is the duplicate, has 6 numbers that are less
   * than or equal to it). Hence, the smallest number that satisfies this property
   * is the duplicate number.
   * 
   * Consider an example: [4,6,4,2,1,4,3,5][4,6,4,2,1,4,3,5]. This has n + 1n+1
   * elements where nn = 77. Take each number from 11 to 77 and count how many
   * numbers are less than or equal to it. In our example,
   * count(1,2,3,4,5,6,7)count(1,2,3,4,5,6,7) = (1,2,3,6,7,8,8)(1,2,3,6,7,8,8). If
   * we performed a linear scan, we would find that the number 44 is the first
   * number to have its counts exceed the actual number (i.e. 6 > 4) - hence 44 is
   * the duplicate. A linear scan based approach would require an overall
   * O(n^2)O(n 2 ) time complexity in the worst case, since we'd need to iterate
   * over each of the nn numbers (requiring O(n)O(n) time), and then compare it to
   * every element to generate a count of equal or lower numbers (requiring
   * O(n)O(n) time as well - nested inside the other O(n)O(n) loop). Fortunately,
   * countcount is monotonic (it's values are always in non-decreasing order), and
   * hence it is an excellent candidate for binary search.
   * 
   * In the binary search approach, instead of doing a linear scan from 11 to nn,
   * we can apply a binary search with a goal of finding the smallest number that
   * satisfies the aforementioned property. We start with a search space of
   * [1,n][1,n] that has a midpoint midmid. If midmid satisfies the property, we
   * narrow our search space to the left half [1, mid - 1][1,mid−1] and continue
   * searching, otherwise, we narrow our search space to the right half [mid + 1,
   * n][mid+1,n].
   * 
   * To observe the monotonicity of count, consider the evaluation: "For the given
   * number, the count of numbers less than or equal to it, exceeds the number
   * itself". Going back to our example, we had derived:
   * count(1,2,3,4,5,6,7)count(1,2,3,4,5,6,7) = (1,2,3,6,7,8,8)(1,2,3,6,7,8,8). If
   * we now take the first number and apply said evaluation, we get falsefalse
   * (since count(1) == 1count(1)==1, which is not greater than 1). Applying this
   * evaluation to all counts, we get (false, false, false, true, true, true,
   * true)(false,false,false,true,true,true,true). Observe how this remains
   * falsefalse in the beginning, and switches to truetrue for the number 4 (i.e.
   * the duplicate), after which point it remains truetrue for all further
   * numbers. Formally, the count for each number must include itself plus the
   * count of all numbers less than itself. Since a number cannot have a negative
   * count, each number, N, must have a count greater than or equal to the count
   * of N-1. Since count(N) >= count(N-1)count(N)>=count(N−1), countcount must be
   * monotonically increasing.
   * @param mid
   * @param nums
   * @return
   */
  private boolean isPossible(int mid, int[] nums) {
    int count = 0;
    for (int i : nums) {
      if (i <= mid) {
        count++;
      }
    }
    return count > mid;
  }

}
