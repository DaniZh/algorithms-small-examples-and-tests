package com.exercise;

import java.util.HashSet;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The array
 * contains an odd number of elements, and each element of the array can be
 * paired with another element that has the same value, except for one element
 * that is left unpaired.
 * 
 * For example, in array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired. Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the function
 * should return 7, as explained in the example above.
 * 
 * Assume that:
 * 
 * N is an odd integer within the range [1..1,000,000]; each element of array A
 * is an integer within the range [1..1,000,000,000]; all but one of the values
 * in A occur an even number of times. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dzheleza
 *
 */
public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] a = { 11, 3, 7, 9, 7, 11, 13 , 9, 3};
		System.out.println(solution1(a));
	}

	/**
	 * O(N^2) complexity
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int result = 0;
		int length = A.length;
		if (length == 0) {
			return 0;
		}
		for (int i = 0; i < length - 1; i++) {
			if (A[i] == 2) {
				continue;
			}
			for (int j = i + 1; j < length; j++) {
				if (A[j] == 2) {
					continue;
				}
				if (A[i] == A[j]) {
					A[i] = 2;
					A[j] = 2;
				}
			}
			if (A[i] != 2) {
				return A[i];
			}
		}
		return A[length - 1];
	}

	/**
	 * O(N) complexity
	 * @param A
	 * @return
	 */
	public static int solution1(int[] A) {
		int length = A.length;
		HashSet<Integer> tt  = new HashSet<Integer>();
		if (length == 0) {
			return 0;
		}
		for (int i = 0; i < length; i++) {
			int tmp = A[i];
			
			if(tt.contains(tmp)){
				tt.remove(tmp);
			}else{
			tt.add(tmp);
			}
		}
		return tt.iterator().next();
	}

}
