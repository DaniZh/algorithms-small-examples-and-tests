package com.exercise.lesson5;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A
 * (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length
 * of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... +
 * A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
 * following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given a non-empty zero-indexed array A consisting of N integers,
 * returns the starting position of the slice with the minimal average. If there
 * is more than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function
 * should return 1, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author dzheleza
 *
 */
public class MinAvgTwoSlice {

	public static void main(String[] args) {
		int[] A ={4,2,2,5,1,5,8};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		//int minPrefSum = 0;
		int minPreffix = 0;
		int maxPreffix = 1;
		int minmax = 0;
		int minDel = 0;
		int length = A.length;
		int[] sumA = new int[length];
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += A[i];
			sumA[i] = sum;
		}
		 minDel = sumA[1];
		 minmax = sumA[1];
		for (int i=2; i<length -1; i++){

			int tmpDelta =sumA[i]-sumA[i-1];
			if(tmpDelta>0 && minDel>=tmpDelta){
				//there is a decrease or slower increase
				//move min prefix 
				minDel = tmpDelta;
				if(i<maxPreffix){
				minPreffix = i;
				}else{
					maxPreffix =i;
				}
			}else  if(tmpDelta<0){
				maxPreffix =i;
			}
		}
		
		return minPreffix;
	}

}
