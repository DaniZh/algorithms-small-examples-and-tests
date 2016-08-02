package com.exercise.lesson6;

/**
 * Find the biggest palindrome in a sring array.
 * 
 * @author dzheleza
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String[] arr = { "a", "aba", "abba", "abccba", "abcdcba", "abcddccba" };
		System.out.println(find(arr));
	}

	public static String find(String[] arr) {
		int palPos = 0;
		int palSize = 0;
		for (int i = 0; i < arr.length; i++) {
			int halfSize = arr[i].length() / 2;
			boolean palTrue = true;
			char[] charArr = arr[i].toCharArray();
			for (int k = 0; k < halfSize; k++) {
				if (charArr[k] != charArr[charArr.length - 1 - k]) {
					palTrue = false;
					break;
				}
			}
			if (palTrue && palSize < arr[i].length()) {
				palSize = arr[i].length();
				palPos = i;
			}
		}
		return arr[palPos];
	}

}
