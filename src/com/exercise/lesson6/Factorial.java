package com.exercise.lesson6;

public class Factorial {
	
	public static  int factorial(int n){
	return	go(1,n);
	}
	
	public static int go(int acc, int n){
		
		if (n == 1) return acc;
		
		return go(acc*n, n-1);
	}

public static int go(int n){
		
		if (n == 1) return 1;
		
		return n*go(n-1);
	}

 public static int fib(int n, int curr, int prev){
	 
	 if(n==0) return prev;
	return  fib(n-1, prev + curr, curr);

 }


	public static void main(String[] args) {
		System.out.println(factorial(5));
		
		System.out.println(fib(6,1,0));

	}

	
}
