package com.exercise;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * 
 * A permutation is a sequence containing each element from 1 to N once, and
 * only once.
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 is a permutation, but array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 is not a permutation, because value 2 is missing.
 * 
 * The goal is to check whether array A is a permutation.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A, returns 1 if array A is a permutation and
 * 0 if it is not.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 the function should return 1.
 * 
 * Given array A such that:
 * 
 * A[0] = 4 A[1] = 1 A[2] = 3 the function should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [1..1,000,000,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dzheleza
 *
 */

public class PermCheck {

	public static void main(String[] args) {
		int [] a = {2,1,3,5,4};
		int [] b = {2,1,3,5,6};
		System.out.println(solution(a));
		System.out.println(solution(b));

	}

	public static int solution(int[] A){
		int result = 1;
		int length  = A.length;
		int [] permArr = new int[length];
		for (int i =0; i<length; i++){
			int tmp = A[i];
			if(tmp<=length){
			permArr[tmp-1]=tmp;
			}
		}
		
		for (int num : permArr){
			if(num == 0){
				result = 0;
				break;
				
			}
		}
		return result;
	}
	
	
	
	
}
