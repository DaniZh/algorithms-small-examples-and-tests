package com.exercise.datastructures;

public class ExerciseQueue {
	
	private int[] queue;
	private int front = -1;
	private int rear = -1;
	private int totalSize  = 5;
	
	public ExerciseQueue(int i){
		 queue = new int [i];
		 front = -1;
		 rear = -1;
		 totalSize  = i;
	}
	
	public void enqueue(int i){
		if((rear +1)%totalSize == front){
			System.out.println("Queue full");
			return ;// Queue full;
		}
		if(isEmpty()){
			rear ++;
			front ++;
			queue[rear] = i;
		}else{
			 rear =(++rear)%totalSize;
			queue[rear] = i;
		}
	}
	
	public int deQueue(){
		
		if(isEmpty()){
			return 0;
		}
		if(rear == front){
			
			int val =  queue[rear];
			rear = -1;
			front = -1;
			return val;
		}else{
			int value = queue[front];
			queue[front] = 0;
			front = (++front)%totalSize;
			return value;
		}
}

	public boolean isEmpty(){
		return (front<0) || (rear<0);
	}
	
	public void listAll(){
		for(int i : queue){
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		ExerciseQueue q = new ExerciseQueue(5);
		q.enqueue(1);
		q.deQueue();
		q.deQueue();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.deQueue();
		q.enqueue(5);
		q.enqueue(5);
		q.listAll();
		q.deQueue();
		q.listAll();
		System.out.println(q.deQueue());
		q.listAll();
		
		
	}
}
