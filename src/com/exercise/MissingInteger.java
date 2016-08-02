package com.exercise;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty zero-indexed array A of N integers, returns the
 * minimal positive integer (greater than 0) that does not occur in A.
 * 
 * For example, given:
 * 
 * A[0] = 1 A[1] = 3 A[2] = 6 A[3] = 4 A[4] = 1 A[5] = 2 the function should
 * return 5.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dzheleza
 *
 */
public class MissingInteger {

	public static void main(String[] args) {
		int[] a = { 2, 1, 3, 5, 6 };
		int[] b = { 1, 2, 4, 3 };
		// System.out.println(solution(a));
		System.out.println(solution(b));
	}

	public static int solution(int[] A) {
		int length = A.length;
		int[] testArr = new int[length];
		int result = 0;
		for (int i = 0; i < length; i++) {
			int tmp = A[i];
			if (tmp <= length && tmp > 0) {
				testArr[tmp - 1] = tmp;
			}
		}
		for (int i = 0; i < length; i++) {
			int tmp = testArr[i];
			if (tmp == 0) {
				result = i + 1;
				break;
			}
		}
		if (result == 0) {
			result = length + 1;
		}
		return result;
	}
}
