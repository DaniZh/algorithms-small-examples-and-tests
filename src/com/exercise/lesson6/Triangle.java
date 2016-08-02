package com.exercise.lesson6;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R)
 * is triangular if 0 ≤ P < Q < R < N and:
 * 
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example,
 * consider array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 Triplet (0, 2, 4) is
 * triangular.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a zero-indexed array A consisting of N integers, returns 1 if
 * there exists a triangular triplet for this array and returns 0 otherwise.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * 
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−2,147,483,648..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(N*log(N)); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dzheleza
 *
 */
public class Triangle {

	public int solution(int[] A) {
		int result = 0;
		A=filter(A);
		if(A.length<3){
			return 0;
		}
		if(!detectAsc(A))
		//Uses dualPivotQuickSort
		Arrays.sort(A);
		//simple manually done MergeSort
		//mergeSort(A);
		int length = A.length;
		for (int i = 2; i < length; i++) {
			
			int P = A[i - 2];
			int Q = A[i - 1];
			int R = A[i];
			
			if ((R - Q) < P) {
				result = 1;
				break;
			}
		
		}
		return result;
	}

	public int [] filter(int []a){
		int positiveCount = 0;
		for (int i =0; i<a.length;i++){
			if(a[i]>0){
				a[positiveCount++] = a[i];
			}
		}
		int [] positiveArr = new int[positiveCount];
		for(int i =0 ; i<positiveCount;i++){
			positiveArr[i] = a [i];
		}
		return positiveArr;
	}
	
	public  void mergeSort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	public  void sort(int[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (hi - lo) / 2 + lo;

		sort(a, lo, mid);
		sort(a, mid + 1, hi);

		merge(a, lo, mid, hi);

	}

	public  void merge(int[] a, int lo, int mid, int hi) {
		int[] aux = new int[a.length];
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}

		int i = lo;
		int t = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[t++];
			else if (t > hi)
				a[k] = aux[i++];
			else if (aux[i] > aux[t]) {
				a[k] = aux[t++];
			} else
				a[k] = aux[i++];
		}
	}
	
	public boolean detectAsc(int[] a) {
		boolean asc = true;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				asc = false;
				break;
			}
		}
		return asc;
	}
	
	public static void main(String[] args) {
		int[] a = { 10, 50, 5, 1};//6, 4, 8};//, 2 };// ,9,5,7,1,3,10};
		Triangle t = new Triangle();
		t.detectAsc(a);
		t.mergeSort(a);
		//mergeSort(a);
	}

}
