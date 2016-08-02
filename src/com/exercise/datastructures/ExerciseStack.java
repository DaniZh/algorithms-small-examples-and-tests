package com.exercise.datastructures;

public class ExerciseStack {

	int defaultSize = 4;
	int[] stack = new int[defaultSize];
	int  top = -1;
	
	public int pop() {
		if(top > -1){
		if(top<stack.length/4){
			decreaseSize();
		}
		}else throw new  RuntimeException("empty stack");
		
		int curr = stack[top];
		//top --;
		//cleans the array.
		stack[top--] = 0;
		return curr;
	}

	public void push(int i){
		if(top <stack.length-1){
			stack[top+1] = i;
			top ++;
		}
		if(top>=stack.length/2){
			icreaseSize();
		}
		
	}

	public void icreaseSize(){
		int[] newArr= new int[(stack.length * 2)];
		for(int i =0 ; i<top+1 ; i++){
			newArr[i] = stack[i];
		}
		this.stack = newArr;
	}

	public void decreaseSize(){
		if(top>=defaultSize){
			int [] newArr = new int[stack.length/2];
		
		for (int i =0 ; i< top+1; i++){
			newArr[i] = stack[i];
		}
		this.stack = newArr;
		}
	}
	public void printAll(){
		for (int i =0; i< top+1; i++){
			System.out.println(stack[i]);
		}
	}

	public static void main(String[] args) {
		ExerciseStack stackDemo = new ExerciseStack();
		stackDemo.printAll();
		  stackDemo.push(23);
		  stackDemo.pop();
		  stackDemo.push(2);
		  stackDemo.printAll();
		  System.out.println("---------------");
		  stackDemo.push(73);
		  stackDemo.push(21);
		  stackDemo.push(22);
		  stackDemo.push(23);
		  stackDemo.push(24);
		  stackDemo.push(25);
		  stackDemo.push(26);
		  stackDemo.push(27);
		  stackDemo.printAll();
		  stackDemo.pop();
		  System.out.println("---------------");

		  stackDemo.printAll();
		  System.out.println("---------------");

		  stackDemo.pop();
		  stackDemo.pop();
		  stackDemo.pop();
		  stackDemo.printAll();
		 
	}
}
