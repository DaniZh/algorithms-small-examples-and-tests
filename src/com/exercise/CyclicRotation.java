package com.exercise;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 * 
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right by K indexes.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); }
 * 
 * that, given a zero-indexed array A consisting of N integers and an integer K,
 * returns the array A rotated K times.
 * 
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should
 * return [9, 7, 6, 3, 8].
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [−1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 * 
 * @author dzheleza
 *
 */
public class CyclicRotation {

	public static void main(String[] args) {
		int[] a = { 3, 8, 9, 7, 6 };
		int[] res = solution(a, 3);
		printarr(res);
	}

	public static int[] solution(int[] A, int K) {
		int[] numArr = A;
		if(A.length == 0){
			return A;
		}
		int lastnum = numArr[numArr.length - 1];
		while (K > 0) {
			for (int i = 0; i < numArr.length; i++) {
				int tmp = numArr[i];
				numArr[i] = lastnum;
				lastnum = tmp;
				if(i ==numArr.length-1){
					numArr[0] = lastnum;
				}
			}
			K--;
		}
		return numArr;
	}

	public static void printarr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}

	}
}
